package com.jjforever.wgj.maincalendar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jjforever.wgj.maincalendar.adapter.TodayHistoryAdapter;
import com.jjforever.wgj.maincalendar.bean.TodayHistory;
import com.jjforever.wgj.maincalendar.bean.TodayHistoryDetail;
import com.jjforever.wgj.maincalendar.http.BUSHTTP;
import com.jjforever.wgj.maincalendar.http.FetcherCallBack;
import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;
import com.jjforever.wgj.maincalendar.util.DateUtil;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 17:22
 */
public class TodayHistoryListActivity extends ToolBarActivity {
    private ListView mListView;
    private List<TodayHistory> mCityList;
    private TodayHistoryAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        showOkBtn(false);
        setTitle("历史上的今天");
        mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new TodayHistoryAdapter(this,mCityList);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TodayHistory history = mCityList.get(position);
                if (history!=null){
                    Intent intent = new Intent();
                    intent.putExtra("eid",history.eid);
                    intent.putExtra("title",history.title);
                    intent.setClass(TodayHistoryListActivity.this,TodayHistoryDetailActivity.class);
                    startActivity(intent);
                }
            }
        });

        int month = DateUtil.getMonth();
        int day = DateUtil.getCurrentMonthDay();
        String date = month + "/"+day;
        BUSHTTP.fetchHistoryList(date, new FetcherCallBack<List<TodayHistory>>() {
            @Override
            public void fetcherSuccess(final List<TodayHistory> result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCityList = result;
                        mAdapter.setData(mCityList);
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void fetcherFail(int code,final String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (!TextUtils.isEmpty(msg)){
                                    Toast.makeText(TodayHistoryListActivity.this,msg,Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(TodayHistoryListActivity.this,"请求失败，请检查网络",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
            }
        });

    }
}
