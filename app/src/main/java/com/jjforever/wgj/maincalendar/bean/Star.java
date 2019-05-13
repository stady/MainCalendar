package com.jjforever.wgj.maincalendar.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 17:01
 */
public class Star {
    @JSONField(name = "fate")
    public String fate;

    @JSONField(name = "constellation")
    public String constellation;

    @JSONField(name = "analysis")
    public String analysis;

    @JSONField(name = "desc")
    public String desc;

    @JSONField(name = "fate_data")
    public List<FateData> fate_data;

    @JSONField(name = "lucky_object")
    public List<String> lucky_object;
}
