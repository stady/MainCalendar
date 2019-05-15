package com.jjforever.wgj.maincalendar.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjforever.wgj.maincalendar.R;
import com.jjforever.wgj.maincalendar.bean.Dream;
import com.jjforever.wgj.maincalendar.bean.TodayHistory;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 18:11
 */
public class TodayHistoryAdapter extends BaseAdapter {
    private Context mContext;
    private List<TodayHistory> dreamList;
    public TodayHistoryAdapter(Context mContext, List<TodayHistory> dreamList){
        this.mContext = mContext;
        this.dreamList = dreamList;
    }

    public void setData( List<TodayHistory> dreamList){
        this.dreamList = dreamList;
    }
    @Override
    public int getCount() {
        return dreamList == null?0:dreamList.size();
    }

    @Override
    public Object getItem(int position) {
        return dreamList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //懒得写VH 反正不在乎性能
        convertView = View.inflate(mContext, R.layout.item_today_history,null);
        TextView titleTv = (TextView) convertView.findViewById(R.id.tv_dream_title);
//        ImageView descTv = (ImageView) convertView.findViewById(R.id.tv_dream_desc);

        TodayHistory dream = dreamList.get(position);
        titleTv.setText(TextUtils.isEmpty(dream.title)?dream.date:dream.title);
//        if (!TextUtils.isEmpty(dream.img)){
//            Picasso.with(mContext).load(dream.img).into(descTv);
//        }


        return convertView;
    }
}
