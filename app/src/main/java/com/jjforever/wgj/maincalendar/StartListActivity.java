package com.jjforever.wgj.maincalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jjforever.wgj.maincalendar.adapter.StarAdapter;
import com.jjforever.wgj.maincalendar.data.DemoData;
import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;

import java.util.List;

/**
 *
 * create by xyl on 2019/5/13 17:22
 */
public class StartListActivity extends ToolBarActivity {
    private ListView mListView;
    private List<String> mStarList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        showOkBtn(false);
        setTitle("选择星座");
        mStarList = DemoData.getStarList();
        mListView = (ListView) findViewById(R.id.list_view);

        mListView.setAdapter(new StarAdapter(this,mStarList));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = mStarList.get(position);
                Intent intent = new Intent();
                intent.putExtra("starName",name);
                intent.setClass(StartListActivity.this,StarDetaiActivity.class);
                startActivity(intent);
            }
        });

    }
}
