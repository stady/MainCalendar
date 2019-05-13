package com.jjforever.wgj.maincalendar.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 17:00
 */
public class Dream {

    @JSONField(name = "title")
    public String title;

    @JSONField(name = "desc")
    public String desc;

    @JSONField(name = "list")
    public List<String> list;

}
