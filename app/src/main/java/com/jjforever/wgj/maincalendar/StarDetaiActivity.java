package com.jjforever.wgj.maincalendar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jjforever.wgj.maincalendar.bean.FateData;
import com.jjforever.wgj.maincalendar.bean.Star;
import com.jjforever.wgj.maincalendar.http.BUSHTTP;
import com.jjforever.wgj.maincalendar.http.FetcherCallBack;
import com.jjforever.wgj.maincalendar.toolbar.ToolBarActivity;

/**
 *
 * create by xyl on 2019/5/13 17:22
 */
public class StarDetaiActivity extends ToolBarActivity {
    private String mStarName;

    private TextView fate_tv;
    private TextView analysis_tv;
    private LinearLayout content_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xingzuo);
        showOkBtn(false);
        content_layout = (LinearLayout) findViewById(R.id.content_layout);
        fate_tv = (TextView) findViewById(R.id.fate_tv);
        analysis_tv = (TextView) findViewById(R.id.analysis_tv);
        mStarName =  getIntent().getExtras().getString("starName");
        setTitle(mStarName);
        BUSHTTP.fetchStar(mStarName, new FetcherCallBack<Star>() {
            @Override
            public void fetcherSuccess(final Star result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result!=null){
                            fate_tv.setText(result.fate);
                            analysis_tv.setText(result.analysis);
                            content_layout.removeAllViews();
                            if (result.fate_data!=null){
                                for (FateData fate_data: result.fate_data){
                                    String str = fate_data.name + fate_data.value;
                                    TextView tv = createTextView();
                                    tv.setText(str);
                                    content_layout.addView(tv);
                                }
                            }
                            if (result.lucky_object!=null){
                                for (String lucky: result.lucky_object){
                                    TextView tv = createTextView();
                                    tv.setText(lucky);
                                    content_layout.addView(tv);
                                }
                            }
                        }
                    }
                });
            }

            @Override
            public void fetcherFail(int code,final String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        analysis_tv.setText("加载失败");
                        if (!TextUtils.isEmpty(msg)){
                            Toast.makeText(StarDetaiActivity.this,msg,Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(StarDetaiActivity.this,"请求失败，请检查网络",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }


    public TextView createTextView(){
        TextView textView = (TextView) View.inflate(this,R.layout.item_content_text_view,null);
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(lp);
        return textView;
    }
}
