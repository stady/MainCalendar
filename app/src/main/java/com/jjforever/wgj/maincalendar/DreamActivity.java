package com.jjforever.wgj.maincalendar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jjforever.wgj.maincalendar.adapter.DreamAdapter;
import com.jjforever.wgj.maincalendar.bean.Dream;
import com.jjforever.wgj.maincalendar.http.BUSHTTP;
import com.jjforever.wgj.maincalendar.http.FetcherCallBack;
import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 17:22
 */
public class DreamActivity extends ToolBarActivity {
    private EditText mKeyWordEdt;
    private ListView mListView;
    private DreamAdapter dreamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream);
        setTitle("周公解梦");
        showOkBtn(false);

        mKeyWordEdt = (EditText) findViewById(R.id.edit_query);
        mListView = (ListView) findViewById(R.id.result_list);
        dreamAdapter = new DreamAdapter(this,null);
        mListView.setAdapter(dreamAdapter);
        findViewById(R.id.btn_query).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.btn_query){
            String key = mKeyWordEdt.getText().toString().trim();
            if (TextUtils.isEmpty(key)){
                Toast.makeText(this,"请输入关键词",Toast.LENGTH_LONG).show();
                return;
            }
            BUSHTTP.fetchDream(key, new FetcherCallBack<List<Dream>>() {
                @Override
                public void fetcherSuccess(final List<Dream> results) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            dreamAdapter.setData(results);
                            dreamAdapter.notifyDataSetChanged();
                        }
                    });

                }

                @Override
                public void fetcherFail(int code, final String msg) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!TextUtils.isEmpty(msg)){
                                Toast.makeText(DreamActivity.this,msg,Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(DreamActivity.this,"请求失败，请检查网络",Toast.LENGTH_LONG).show();
                            }
                        }
                    });


                }
            });
        }
    }
}
