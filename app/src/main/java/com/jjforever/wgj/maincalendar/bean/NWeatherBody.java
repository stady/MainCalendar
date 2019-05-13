package com.jjforever.wgj.maincalendar.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 16:05
 */
public class NWeatherBody {
    @JSONField(name = "province")
    public String province;

    @JSONField(name = "province_py")
    public String province_py;

    @JSONField(name = "city")
    public String city;

    @JSONField(name = "city_py")
    public String city_py;

    @JSONField(name = "city_id")
    public String city_id;


    @JSONField(name = "post_code")
    public String post_code;


    @JSONField(name = "area_code")
    public String area_code;


    @JSONField(name = "now")
    public List<WeatherNow> now;


}

