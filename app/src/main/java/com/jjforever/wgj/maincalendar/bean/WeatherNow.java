package com.jjforever.wgj.maincalendar.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 16:05
 */
public class WeatherNow {
    @JSONField(name = "now_rain")
    public String now_rain;

    @JSONField(name = "now_feelst")
    public String now_feelst;

    @JSONField(name = "now_humidity")
    public String now_humidity;

    @JSONField(name = "now_icomfort")
    public String now_icomfort;

    @JSONField(name = "now_rcomfort")
    public String now_rcomfort;


    @JSONField(name = "now_wind_power")
    public String now_wind_power;


    @JSONField(name = "now_airpressure")
    public String now_airpressure;


    @JSONField(name = "now_temperature")
    public String now_temperature;



    @JSONField(name = "now_publish_time")
    public String now_publish_time;



    @JSONField(name = "now_wind_direction")
    public String now_wind_direction;
}

