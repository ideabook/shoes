package top.tupobi.www.speed;

/**
 * Created by Administrator on 2018/6/28/028.
 */

public class Cache {
    private String username;
    private String password;
    private int todaySteps;
    private String date;
    private double longitude;
    private double latitude;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTodaySteps() {
        return todaySteps;
    }

    public void setTodaySteps(int todaySteps) {
        this.todaySteps = todaySteps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Cache{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", " +
                "" + "todaySteps=" + todaySteps + ", date='" + date + '\'' + ", longitude=" +
                longitude + ", latitude=" + latitude + '}';
    }
}
