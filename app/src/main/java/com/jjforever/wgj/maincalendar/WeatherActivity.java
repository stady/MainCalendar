package com.jjforever.wgj.maincalendar;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jjforever.wgj.maincalendar.bean.NWeatherBody;
import com.jjforever.wgj.maincalendar.bean.WeatherNow;
import com.jjforever.wgj.maincalendar.http.BUSHTTP;
import com.jjforever.wgj.maincalendar.http.FetcherCallBack;
import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 17:22
 */
public class WeatherActivity extends ToolBarActivity {
    private String mCityName;

    private TextView city_tv;
    private TextView now_rain_tv;
    private TextView now_feelst_tv;
    private TextView now_humidity_tv;
    private TextView now_icomfort_tv;
    private TextView now_rcomfort_tv;
    private TextView now_wind_power_tv;
    private TextView now_airpressure_tv;
    private TextView now_temperature_tv;
    private TextView now_publish_time_tv;
    private TextView now_wind_direction_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        showOkBtn(false);
        mCityName =  getIntent().getExtras().getString("cityName");
        setTitle(mCityName);

        city_tv = (TextView) findViewById(R.id.city_tv);
        now_rain_tv = (TextView) findViewById(R.id.now_rain_tv);
        now_feelst_tv = (TextView) findViewById(R.id.now_feelst_tv);
        now_humidity_tv = (TextView) findViewById(R.id.now_humidity_tv);
        now_icomfort_tv = (TextView) findViewById(R.id.now_icomfort_tv);
        now_rcomfort_tv = (TextView) findViewById(R.id.now_rcomfort_tv);
        now_wind_power_tv = (TextView) findViewById(R.id.now_wind_power_tv);
        now_airpressure_tv = (TextView) findViewById(R.id.now_airpressure_tv);
        now_temperature_tv = (TextView) findViewById(R.id.now_temperature_tv);
        now_publish_time_tv = (TextView) findViewById(R.id.now_publish_time_tv);
        now_wind_direction_tv = (TextView) findViewById(R.id.now_wind_direction_tv);

        BUSHTTP.fetchWeather(mCityName, new FetcherCallBack<NWeatherBody>() {
            @Override
            public void fetcherSuccess(final NWeatherBody result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result!=null){
                            city_tv.setText(result.city);
                            if (result.now!=null && result.now.size()>0){
                                WeatherNow weatherNow= result.now.get(0);
                                now_rain_tv.setText("当前降雨：" +weatherNow.now_rain);
                                now_feelst_tv.setText("体感温度：" +weatherNow.now_feelst);
                                now_humidity_tv.setText("当前湿度：" +weatherNow.now_humidity);
                                now_icomfort_tv.setText("舒适度：" +weatherNow.now_icomfort);
                                now_rcomfort_tv.setText("空气质量：" +weatherNow.now_rcomfort);
                                now_wind_power_tv.setText("风力：" +weatherNow.now_wind_power);
                                now_airpressure_tv.setText("气压：" +weatherNow.now_airpressure);
                                now_temperature_tv.setText("当前温度：" +weatherNow.now_temperature);
                                now_publish_time_tv.setText("发布时间：" +weatherNow.now_publish_time);
                                now_wind_direction_tv.setText("风向：" +weatherNow.now_wind_direction);

                            }

                        }
                    }
                });
            }

            @Override
            public void fetcherFail(int code,final String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (!TextUtils.isEmpty(msg)){
                                    Toast.makeText(WeatherActivity.this,msg,Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(WeatherActivity.this,"请求失败，请检查网络",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
            }
        });
    }
}
