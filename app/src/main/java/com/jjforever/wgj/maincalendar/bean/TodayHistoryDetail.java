package com.jjforever.wgj.maincalendar.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 16:53
 */
public class TodayHistoryDetail {

    @JSONField(name = "content")
    public String content;

    @JSONField(name = "day")
    public String day;

    @JSONField(name = "imgs")
    public List<TodayHistoryImage> imgs;

    @JSONField(name = "picNo")
    public String picNo;

    @JSONField(name = "title")
    public String title;
}
