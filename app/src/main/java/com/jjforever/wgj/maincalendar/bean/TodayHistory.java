package com.jjforever.wgj.maincalendar.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 16:52
 */
public class TodayHistory {
    @JSONField(name = "date")
    public String date;

    @JSONField(name = "day")
    public String day;

    @JSONField(name = "eid")
    public String eid;

    @JSONField(name = "img")
    public String img;

    @JSONField(name = "title")
    public String title;
}
