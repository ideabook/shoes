package top.tupobi.www.speed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.juma.sdk.JumaDevice;
import com.juma.sdk.JumaDeviceCallback;
import com.juma.sdk.ScanHelper;
import com.juma.sdk.ScanHelper.ScanCallback;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import okhttp3.Call;

//http://210.28.44.35:8080/ShoesSys/shoes_adduser.action
//http://210.28.44.35:8080/ShoesSys/shoes_update.action
//userName stepCounts longitude latitude
public class MainActivity extends Activity {
    private TextView tvMil, tvSpeed, tvBattery, tvTime, tvTemp, tvW, tvTodaySteps, tvDistance;
    private Button btReset, btnSimulateCountSteps;
    private Spinner spDevice, spD;
    private BluetoothAdapter mBluetoothAdapter;
    private ScanHelper scanner;
    private JumaDevice myDevice = null;
    private boolean clearnumber = false, redata = true;
    private int n = 0, m = 0, t = 1;
    private double d = 0;
    private List<JumaDevice> deviceList = new ArrayList<JumaDevice>();
    private List<UUID> uuidList = new ArrayList<UUID>();
    private List<String> NameList = new ArrayList<String>();
    private ArrayAdapter<String> apName, apWD;
    private double[] wd = {406, 451, 559, 584, 622};
    //    private static final String[] WD = {"φ406mm", "φ451mm", "φ559mm", "φ584mm", "φ622mm"};
    private static final String[] WD = {"40厘米", "45厘米", "50厘米", "55厘米", "60厘米"};
    DecimalFormat df;
    private double mLongitude, mLatitude;
    private double mTodayStepCounts;
    private int mPreThisTimeStpes, mCurThisTimeSteps;
    private Timer mTimer;
    private TimerTask mTimerTask;

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLngAndLatWithNetwork();
        getLngAndLat(MainActivity.this);
        initView();
        df = new DecimalFormat("######0.0");
        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context
                .BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();
        initDevice();
        onBtClick();
        if (mBluetoothAdapter.isEnabled()) {
            scanner.startScan(null);
        } else {
            Toast.makeText(getApplicationContext(), "请打开蓝牙", Toast.LENGTH_SHORT).show();
        }

        tvTodaySteps = findViewById(R.id.tv_today_step_counts);
        tvDistance = findViewById(R.id.tv_distance);
        Cache cacheUser = GsonUtil.json2Bean(SpUtils.getInstance().getString(AtyLogin.USER_CACHE,
                ""), Cache.class);
        tvTodaySteps.setText("" + cacheUser.getTodaySteps());
        String item = (String) spD.getSelectedItem();
        double stepLength = 0.4;
        switch (item) {
            case "40厘米":
                stepLength = 0.4;
                break;
            case "45里面":
                stepLength = 0.45;
                break;
            case "50厘米":
                stepLength = 0.5;
                break;
            case "55厘米":
                stepLength = 0.55;
                break;
            case "60厘米":
                stepLength = 0.6;
                break;
        }
        double distance = cacheUser.getTodaySteps() * stepLength;
        distance = new BigDecimal(distance).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        tvDistance.setText("" + distance);
    }

    private Handler handler = new Handler();
    String hh = "00", mm = "00", ss = "00";
    int h = 0, M = 0, s = 0;
    private Runnable runnable = new Runnable() {
        public void run() {
            t++;
            h = t / 3600;
            M = t / 60;
            s = t % 60;
            hh = (h > 9 ? "" + h : "0" + h);
            mm = (M > 9 ? "" + M : "0" + M);
            ss = (s > 9 ? "" + s : "0" + s);
            if (M > 40 || h == 1) {
                tvTime.setText("YOU should rest:" + hh + ":" + mm + ":" + ss);
            } else if (h == 2) {
                tvTime.setText("Strike");
            } else {
                tvTime.setText(hh + ":" + mm + ":" + ss);
            }
            handler.postDelayed(runnable, 1000);
        }
    };
    private JumaDeviceCallback callback = new JumaDeviceCallback() {
        @Override
        public void onConnectionStateChange(int status, int newState) {
            // TODO Auto-generated method stub
            super.onConnectionStateChange(status, newState);
            if (newState == JumaDevice.STATE_CONNECTED && status == JumaDevice.SUCCESS) {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        btReset.setText("暂停计步");
                        tvTime.setText("00:00:01");
                        handler.postDelayed(runnable, 1000);
                    }

                });

            } else if (newState == JumaDevice.STATE_DISCONNECTED) {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        handler.removeCallbacks(runnable);
                        if (clearnumber) {
                            clearnumber = false;
                            n = 0;
                            m = 0;
                            t = 1;
                            deviceList.clear();
                            uuidList.clear();
                            NameList.clear();
                            apName.clear();
                            apName.add("选择设备");
                            apName.addAll(NameList);
                            spDevice.setAdapter(apName);
                            tvBattery.setText("—————");
                            tvBattery.setTextColor(Color.BLACK);
//							tvTemp.setText("0℃");
                        }
                        btReset.setText("开始计步");
                        scanner.startScan(null);
                    }

                });

            }
        }

        private short bx = 0, by = 0, bz = 0, x = 0, y = 0, bT = 0, bV = 0;

        @Override
        public void onReceive(byte type, byte[] message) {
            // TODO Auto-generated method stub
            super.onReceive(type, message);
            if (redata) {
                redata = false;
                bx = 0;
                bx |= message[0];
                bx <<= 8;
                bx |= (message[1] & 0x00FF);
                by = 0;
                by |= message[2];
                by <<= 8;
                by |= (message[3] & 0x00FF);
                bz = 0;
                bz |= message[4];
                bz <<= 8;
                bz |= (message[5] & 0x00FF);
                bT = 0;
                bT |= message[7];
                bV = 0;
                bV |= message[6];
                if (bx > 0 && x < 0 || bx < 0 && x > 0) {
                    n++;
                }
                if (by > 0 && y < 0 || by < 0 && y > 0) {
                    m++;
                }
                x = bx;
                y = by;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (MainActivity.class) {

                            // TODO Auto-generated method stub
//                        mPreThisTimeStpes = Integer.valueOf(tvMil.getText().toString());
                            tvMil.setText("" + (int) ((n < m ? n / 2 : m / 2) * d));
//                        tvSpeed.setText(df.format((((double) ((n < m ? n / 2 : m / 2) * d) / t) *
//                                3.6)) + "");
                            tvSpeed.setText(df.format((((double) ((n < m ? n / 2 : m / 2) * d) /
                                    t) * 1.0)) + "");
                            tvTemp.setText(bT + "℃");
                            tvBattery.setTextColor(Color.GREEN);
                            switch (bV) {
                                case 1:
                                    tvBattery.setTextColor(Color.RED);
                                    tvBattery.setText("○○○○●");
                                    break;
                                case 2:
                                    tvBattery.setText("○○○●●");
                                    break;
                                case 3:
                                    tvBattery.setText("○○●●●");
                                    break;
                                case 4:
                                    tvBattery.setText("○●●●●");
                                    break;
                                case 5:
                                    tvBattery.setText("●●●●●");
                                    break;
                            }
                            mCurThisTimeSteps = (int) ((n < m ? n / 2 : m / 2) * d);
                            if (mCurThisTimeSteps != mPreThisTimeStpes) {
                                int thisTimeSteps = (int) ((n < m ? n / 2 : m / 2) * d);
                                LogUtil.e("thisTimeSteps == " + thisTimeSteps);
                                Cache cache = GsonUtil.json2Bean(SpUtils.getInstance().getString
                                        (AtyLogin.USER_CACHE, ""), Cache.class);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat
                                        ("yyyy-MM-dd");
                                String today = simpleDateFormat.format(new Date());
                                if (cache.getDate() == null || cache.getDate().isEmpty() ||
                                        !cache.getDate().equals(today)) {
                                    //新增今日步数
                                    cache.setTodaySteps(thisTimeSteps);
                                    cache.setDate(today);
                                } else {
                                    //更新今日步数
                                    cache.setTodaySteps(1 + cache.getTodaySteps());
                                    if (cache.getTodaySteps() <= (int) ((n < m ? n / 2 : m / 2) *
                                            d)) {
                                        cache.setTodaySteps((int) ((n < m ? n / 2 : m / 2) * d));
                                    }
                                    tvTodaySteps.setText("" + cache.getTodaySteps());
                                    String item = (String) spD.getSelectedItem();
                                    double stepLength = 0.4;
                                    switch (item) {
                                        case "40厘米":
                                            stepLength = 0.4;
                                            break;
                                        case "45里面":
                                            stepLength = 0.45;
                                            break;
                                        case "50厘米":
                                            stepLength = 0.5;
                                            break;
                                        case "55厘米":
                                            stepLength = 0.55;
                                            break;
                                        case "60厘米":
                                            stepLength = 0.6;
                                            break;
                                    }
                                    double distance = cache.getTodaySteps() * stepLength;
                                    distance = new BigDecimal(distance).setScale(2, BigDecimal
                                            .ROUND_HALF_UP).doubleValue();
                                    tvDistance.setText("" + distance);
                                }
                                SpUtils.getInstance().save(AtyLogin.USER_CACHE, GsonUtil
                                        .bean2Json(cache));
                                getLngAndLatWithNetwork();
                                getLngAndLat(MainActivity.this);

//                                uploadData();
                            }
                            mPreThisTimeStpes = mCurThisTimeSteps;
                            redata = true;

                        }
                    }
                });
            }

        }
    };

    private void uploadData() {
//        userName stepCounts longitude latitude
        String cachedJson = SpUtils.getInstance().getString(AtyLogin.USER_CACHE, "");
        Cache cache = GsonUtil.json2Bean(cachedJson, Cache.class);
        String userName = cache.getUsername();
        int stepCounts = cache.getTodaySteps();
        double longitude = mLongitude;
        double latitude = mLatitude;
        LogUtil.e("upload: username == " + userName + ", stepCounts == " + stepCounts + ", " +
                "longitude == " + longitude + ", latitude == " + latitude);

//        double[] laLg = MainActivity.postBaidu(mLatitude, mLongitude);
//        double baiduLat = laLg[0];
//        double baiduLng = laLg[1];
//        LogUtil.e("source: " + "latitude == " + mLatitude + ", longitude == " + longitude);
//        LogUtil.e("baidu: " + "baiduLatitude == " + baiduLat + ", baiduLogitude == " + baiduLng);

        //上传数据部分
        //userName stepCounts longitude latitude
//        OkHttpUtils.post().url("http://210.28.44.35:8080/ShoesSys/shoes_update.action")
        OkHttpUtils.post().url("http://" + HttpConfig.ip + ":8080/ShoesSys/shoes_update.action")
                .addParams("userName", userName).addParams("stepCounts", String.valueOf
                (stepCounts)).addParams("longitude", String.valueOf(longitude)).addParams
                ("latitude", String.valueOf(latitude)).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtil.e("response == ");
            }
        });
    }

    private void onBtClick() {
        btReset.setOnClickListener(new OnClickListener() {

            @SuppressLint("ShowToast")
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if (btReset.getText().equals("开始计步")) {
                    if (myDevice != null) {
                        tvW.setTextColor(Color.BLACK);
                        btReset.setText("暂停计步");
                        d = wd[spD.getSelectedItemPosition()] / 1000 * 3.14;
                        scanner.stopScan();

                        //开始定时上传
                        mTimerTask = new TimerTask() {
                            @Override
                            public void run() {
                                uploadData();
                            }
                        };
                        mTimer = new Timer();
                        mTimer.schedule(mTimerTask, 30 * 1000, 30 * 1000);
                    } else {
                        tvW.setTextColor(Color.RED);
                        Toast.makeText(getApplicationContext(), "请选择设备", Toast.LENGTH_SHORT).show();
                    }
                } else if (btReset.getText().equals("暂停计步")) {
                    clearnumber = true;
                    myDevice.disconnect();

                    //取消定时上传
                    if (mTimer != null) {
                        mTimer.cancel();
                        mTimer = null;
                    }
                    if (mTimerTask != null) {
                        mTimerTask.cancel();
                        mTimerTask = null;
                    }
                }


            }
        });
        spDevice.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (myDevice != null && myDevice.isConnected()) {
                    myDevice.disconnect();
                }
                if (!apName.getItem(position).equals("选择设备")) {
                    myDevice = deviceList.get(position - 1);
                } else {
                    myDevice = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private Timer siTimer;
    private TimerTask siTimerTask;
    public static final String siJsonCacheFlag = "siJsonCacheFlag";
    private int siTodayStepCounts = 0;
    private int siSecondsStepCounts = 0;
    private int siThisTimeSteps = 0;

    private Timer siPostDataTimer;
    private TimerTask siPostTimerTask;

    private void initView() {
        tvMil = (TextView) findViewById(R.id.tvmil);
        tvW = (TextView) findViewById(R.id.tvw);
        tvSpeed = (TextView) findViewById(R.id.tvspeed);
        tvBattery = (TextView) findViewById(R.id.tvbattery);
        tvTemp = (TextView) findViewById(R.id.tvtemp);
        tvTime = (TextView) findViewById(R.id.tvtime);
        btReset = (Button) findViewById(R.id.btreset);
        spDevice = (Spinner) findViewById(R.id.spdevice);
        spD = (Spinner) findViewById(R.id.spd);
        btnSimulateCountSteps = findViewById(R.id.btn_simulate_count_steps);
        apWD = new ArrayAdapter<String>(this, R.layout.message, WD);
        spD.setAdapter(apWD);
        apName = new ArrayAdapter<String>(this, R.layout.message);
        apName.add("选择设备");
        spDevice.setAdapter(apName);

        btnSimulateCountSteps.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("开始模拟计步".equals(btnSimulateCountSteps.getText())) {
                    //开始模拟计步
                    btReset.setClickable(false);
                    btReset.setEnabled(false);
                    btReset.setBackgroundColor(Color.parseColor("#CFCFCF"));
                    btnSimulateCountSteps.setText("停止模拟计步");

                    siTimerTask = new TimerTask() {
                        @Override
                        public void run() {
                            LogUtil.e("任务中");
                            String siJsonCachedData = SpUtils.getInstance().getString
                                    (siJsonCacheFlag, "");

                            Cache cacheData = GsonUtil.json2Bean(siJsonCachedData, Cache.class);
                            siTodayStepCounts = cacheData.getTodaySteps();
                            LogUtil.e("cacheData == " + cacheData);
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String today = simpleDateFormat.format(new Date());
                            if (cacheData != null || cacheData.getDate().isEmpty() || today
                                    .equals(cacheData.getDate())) {
                                //添加一个模拟步数
                                cacheData.setDate(today);
//                                getLngAndLatWithNetwork();
                                getLngAndLat(MainActivity.this);
                                cacheData.setLongitude(mLongitude);
                                cacheData.setLatitude(mLatitude);
                                siSecondsStepCounts = (int) (Math.random() * 3);
                                siThisTimeSteps += siSecondsStepCounts;
                                siTodayStepCounts += siSecondsStepCounts;
                                cacheData.setTodaySteps(siTodayStepCounts);
                                //存入缓存
                                siJsonCachedData = GsonUtil.bean2Json(cacheData);
                                SpUtils.getInstance().save(siJsonCacheFlag, siJsonCachedData);
                                //设置数据
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvTodaySteps.setText(siTodayStepCounts + "");
                                        tvMil.setText(siThisTimeSteps + "");
                                        double speed = new BigDecimal((siSecondsStepCounts * 0.4)
                                        ).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                        tvSpeed.setText(speed + "");
                                        double distance = new BigDecimal((siTodayStepCounts *
                                                0.4)).setScale(2, BigDecimal.ROUND_HALF_UP)
                                                .doubleValue();
                                        tvDistance.setText(distance + "");
                                    }
                                });
                            } else {
                                //更新一个模拟步数
                                getLngAndLatWithNetwork();
                                getLngAndLat(MainActivity.this);
                                cacheData.setLongitude(mLongitude);
                                cacheData.setLatitude(mLatitude);
                                siSecondsStepCounts = (int) (Math.random() * 3);
                                siThisTimeSteps += siSecondsStepCounts;
                                LogUtil.e("siSecondsStepCounts == " + siSecondsStepCounts);
                                siTodayStepCounts = cacheData.getTodaySteps() + siSecondsStepCounts;
                                LogUtil.e("siTodayStepCounts == " + siTodayStepCounts);
                                cacheData.setTodaySteps(siTodayStepCounts);
                                //存入缓存
                                siJsonCachedData = GsonUtil.bean2Json(cacheData);
                                SpUtils.getInstance().save(siJsonCacheFlag, siJsonCachedData);
                                //设置数据
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvTodaySteps.setText(siTodayStepCounts + "");
                                        tvMil.setText(siThisTimeSteps + "");
                                        double speed = new BigDecimal((siSecondsStepCounts * 0.4)
                                        ).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                        tvSpeed.setText(speed + "");
                                        double distance = new BigDecimal((siTodayStepCounts *
                                                0.4)).setScale(2, BigDecimal.ROUND_HALF_UP)
                                                .doubleValue();
                                        tvDistance.setText(distance + "");
                                    }
                                });
                            }
                        }
                    };
                    siTimer = new Timer();
                    LogUtil.e("定时开始：");
                    siTimer.schedule(siTimerTask, 1000, 1000);


                    siPostDataTimer = new Timer();
                    siPostTimerTask = new TimerTask() {
                        @Override
                        public void run() {
                            String siJsonCachedData = SpUtils.getInstance().getString
                                    (siJsonCacheFlag, "");

                            Cache cacheData = GsonUtil.json2Bean(siJsonCachedData, Cache.class);
                            //http://210.28.44.35:8080/ShoesSys/shoes_update.action
                            //userName stepCounts longitude latitude
                            String userName = cacheData.getUsername();
                            int stepCounts = cacheData.getTodaySteps();
                            double longitude = cacheData.getLongitude();
                            double latitude = cacheData.getLatitude();

                            LogUtil.e("post data == " + cacheData);

                            OkHttpUtils.post().url("http://" + HttpConfig.ip +
                                    ":8080/ShoesSys/shoes_update.action").addParams("userName",
                                    userName).addParams("stepCounts", String.valueOf(stepCounts))
                                    .addParams("longitude", String.valueOf(longitude)).addParams
                                    ("latitude", String.valueOf(latitude)).build().execute(new StringCallback() {
                                @Override
                                public void onError(Call call, Exception e, int id) {
                                    e.printStackTrace();
                                }

                                @Override
                                public void onResponse(String response, int id) {
                                    LogUtil.e(response);
                                }
                            });
                        }
                    };
                    siPostDataTimer.schedule(siPostTimerTask, 30 * 1000, 30 * 1000);

                } else if ("停止模拟计步".equals(btnSimulateCountSteps.getText())) {
                    //停止模拟计步
                    btReset.setClickable(true);
                    btReset.setEnabled(true);
                    btReset.setBackgroundColor(Color.parseColor("#ffffff"));
                    btnSimulateCountSteps.setText("开始模拟计步");


                    if (siTimer != null) {
                        siTimer.cancel();
                        siTimer = null;
                    }
                    if (siTimerTask != null) {
                        siTimerTask.cancel();
                        siTimerTask = null;
                    }

                    if (siPostDataTimer != null) {
                        siPostDataTimer.cancel();
                        siPostDataTimer = null;
                    }
                    if (siPostTimerTask != null) {
                        siPostTimerTask.cancel();
                        siPostTimerTask = null;
                    }
                }
            }
        });
    }

    private void initDevice() {
        scanner = new ScanHelper(getApplicationContext(), new ScanCallback() {

            @Override
            public void onScanStateChange(int status) {
                // TODO Auto-generated method stub
                if (status == ScanHelper.STATE_STOP_SCAN) {
                    myDevice.connect(callback);
                }

            }

            @Override
            public void onDiscover(JumaDevice device, int arg1) {
                // TODO Auto-generated method stub
                if (!uuidList.contains(device.getUuid())) {
                    uuidList.add(device.getUuid());
                    deviceList.add(device);
                    NameList.add(device.getName());
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            apName.clear();
                            apName.add("选择设备");
                            apName.addAll(NameList);
                            spDevice.setAdapter(apName);

                        }

                    });
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 获取经纬度
     *
     * @param context
     * @return
     */
    private String getLngAndLat(Context context) {
        double latitude = 0.0;
        double longitude = 0.0;
        LocationManager locationManager = (LocationManager) context.getSystemService(Context
                .LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {  //从gps获取经纬度
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            } else {//当GPS信号弱没获取到位置的时候又从网络获取
                return getLngAndLatWithNetwork();
            }
        } else {    //从网络获取经纬度
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0,
                    locationListener);
            Location location = locationManager.getLastKnownLocation(LocationManager
                    .NETWORK_PROVIDER);
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }
        }
        mLatitude = latitude;
        mLongitude = longitude;
        return longitude + "," + latitude;
    }

    //从网络获取经纬度
    public String getLngAndLatWithNetwork() {
        double latitude = 0.0;
        double longitude = 0.0;
        LocationManager locationManager = (LocationManager) getSystemService(Context
                .LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0,
                locationListener);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
        mLatitude = latitude;
        mLongitude = longitude;
        return longitude + "," + latitude;
    }


    LocationListener locationListener = new LocationListener() {

        // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        // Provider被enable时触发此函数，比如GPS被打开
        @Override
        public void onProviderEnabled(String provider) {

        }

        // Provider被disable时触发此函数，比如GPS被关闭
        @Override
        public void onProviderDisabled(String provider) {

        }

        //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
        @Override
        public void onLocationChanged(Location location) {
        }
    };

}
