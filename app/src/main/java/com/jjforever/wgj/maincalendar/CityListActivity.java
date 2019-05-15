package com.jjforever.wgj.maincalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jjforever.wgj.maincalendar.adapter.StarAdapter;
import com.jjforever.wgj.maincalendar.data.DemoData;
import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 17:25
 */
public class CityListActivity extends ToolBarActivity {
    private ListView mListView;
    private List<String> mCityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        showOkBtn(false);
        setTitle("选择城市");
        mCityList = DemoData.getCityList();
        mListView = (ListView) findViewById(R.id.list_view);

        mListView.setAdapter(new StarAdapter(this,mCityList));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = mCityList.get(position);
                Intent intent = new Intent();
                intent.putExtra("cityName",name);
                intent.setClass(CityListActivity.this,WeatherActivity.class);
                startActivity(intent);
            }
        });
    }
}
