package top.tupobi.www.speed;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

//http://210.28.44.35:8080/ShoesSys/shoes_adduser.action
public class AtyLogin extends Activity {

    public static final String USER_CACHE = "user_cache";
    private ImageView mImageView;
    private EditText mEtUsername, mEtPassword, mEtIp;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!SpUtils.getInstance().getString(AtyLogin.USER_CACHE, "").isEmpty()) {
            MainActivity.actionStart(this);
            finish();
        }
        setContentView(R.layout.aty_login);

        initView();
    }

    private void initView() {
        mImageView = findViewById(R.id.iv_login_bg);
        mEtUsername = findViewById(R.id.tiet_username);
        mEtPassword = findViewById(R.id.tiet_passsword);
        mEtIp = findViewById(R.id.tiet_ip);
//        mBtnLogin = findViewById(R.id.btn_normal_login);
        mBtnRegister = findViewById(R.id.btn_register);

        Glide.with(this).load(R.drawable.login_bg_3);

//        mBtnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = mEtUsername.getText().toString().trim();
//                String password = mEtPassword.getText().toString().trim();
//                if (username.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(AtyLogin.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                login(username, password);
//            }
//        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEtUsername.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                String ip = mEtIp.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty() || ip.isEmpty()) {
                    Toast.makeText(AtyLogin.this, "账号密码IP不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                HttpConfig.ip = ip;
                register(username, password);
            }
        });
    }

    private void register(final String username, final String password) {
        //1. 注册
        //2. 判断是否注册成功
        //3. 缓存
//        OkHttpUtils.post().url("http://210.28.44.35:8080/ShoesSys/shoes_adduser.action")

        OkHttpUtils.post().url("http://" + HttpConfig.ip + ":8080/ShoesSys/shoes_adduser.action")
                .addParams("userName", username).addParams("passWord", password).build().execute
                (new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response, int id) {
                if (response.contains("1")) {
                    cacheUser(username, password);
                    MainActivity.actionStart(AtyLogin.this);
                } else {
                    Toast.makeText(AtyLogin.this, "用户名重复或网络异常", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        cacheUser(username, password);
//        MainActivity.actionStart(AtyLogin.this);
    }

    private void login(String username, String password) {
        //1. 判断是否登录成功
        //2. 成功后缓存，然后进入主页面
//        cacheUser(username, password);

    }

    private void cacheUser(String username, String password) {
        Cache cache = new Cache();
        cache.setUsername(username);
        cache.setPassword(password);
        String userCache = GsonUtil.bean2Json(cache);
        SpUtils.getInstance().save(AtyLogin.USER_CACHE, userCache);
        SpUtils.getInstance().save(MainActivity.siJsonCacheFlag, userCache);
        LogUtil.e("cache user info == " + SpUtils.getInstance().getString(AtyLogin.USER_CACHE, ""));
    }
}
