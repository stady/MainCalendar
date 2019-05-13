package com.jjforever.wgj.maincalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 15:23
 */
public class MoreActivity extends ToolBarActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        showOkBtn(false);
        setTitle(getResources().getString(R.string.action_more));
    }
}
