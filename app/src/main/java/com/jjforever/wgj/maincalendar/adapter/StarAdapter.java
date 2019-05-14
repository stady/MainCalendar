package com.jjforever.wgj.maincalendar.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jjforever.wgj.maincalendar.R;
import com.jjforever.wgj.maincalendar.bean.Dream;

import java.util.List;

/**
 * TODO  discription
 * create by xyl on 2019/5/13 18:11
 */
public class StarAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> dreamList;
    public StarAdapter(Context mContext, List<String> dreamList){
        this.mContext = mContext;
        this.dreamList = dreamList;
    }

    public void setData( List<String> dreamList){
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
        convertView = View.inflate(mContext, R.layout.item_star,null);
        TextView titleTv = (TextView) convertView.findViewById(R.id.tv_star_name);

        String dream = dreamList.get(position);
        titleTv.setText(dream);

        return convertView;
    }
}
