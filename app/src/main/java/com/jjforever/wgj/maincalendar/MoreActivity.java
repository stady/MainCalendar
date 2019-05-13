package com.jjforever.wgj.maincalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jjforever.wgj.maincalendar.data.URL;
import com.jjforever.wgj.maincalendar.http.FetcherCallBack;
import com.jjforever.wgj.maincalendar.http.HttpUtil;
import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 15:23
 */
public class MoreActivity extends ToolBarActivity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        showOkBtn(false);
        findViewById(R.id.weather_btn).setOnClickListener(this);
        findViewById(R.id.dream_btn).setOnClickListener(this);
        findViewById(R.id.history_btn).setOnClickListener(this);
        findViewById(R.id.star_btn).setOnClickListener(this);
        setTitle(getResources().getString(R.string.action_more));
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.weather_btn:{
                intent.setClass(this,CityListActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.dream_btn:{
                intent.setClass(this,DreamActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.history_btn:{
                intent.setClass(this,TodayHistoryListActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.star_btn:{
                intent.setClass(this,StartListActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
