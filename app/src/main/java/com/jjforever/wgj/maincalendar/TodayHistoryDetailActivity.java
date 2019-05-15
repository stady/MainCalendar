package com.jjforever.wgj.maincalendar;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.jjforever.wgj.maincalendar.bean.TodayHistoryDetail;
import com.jjforever.wgj.maincalendar.http.BUSHTTP;
import com.jjforever.wgj.maincalendar.http.FetcherCallBack;
import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 17:22
 */
public class TodayHistoryDetailActivity extends ToolBarActivity {
    private TextView title_tv;
    private TextView content_tv;
    private TextView date_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        title_tv = (TextView) findViewById(R.id.title_tv);
        content_tv = (TextView) findViewById(R.id.content_tv);
        date_tv = (TextView) findViewById(R.id.date_tv);
        String title = getIntent().getStringExtra("title");
        String eid = getIntent().getStringExtra("eid");
        showOkBtn(false);
        setTitle(title);

        BUSHTTP.fetchHistoryDetail(eid, new FetcherCallBack<TodayHistoryDetail>() {
            @Override
            public void fetcherSuccess(final TodayHistoryDetail result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result!=null){
                            title_tv.setText(result.title);
                            content_tv.setText(result.content);
                            date_tv.setText(result.day);
                        }
                    }
                });
            }

            @Override
            public void fetcherFail(int code,final String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!TextUtils.isEmpty(msg)){
                            Toast.makeText(TodayHistoryDetailActivity.this,msg,Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(TodayHistoryDetailActivity.this,"请求失败，请检查网络",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
