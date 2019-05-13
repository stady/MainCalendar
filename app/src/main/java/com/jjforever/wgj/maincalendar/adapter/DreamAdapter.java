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
public class DreamAdapter extends BaseAdapter {
    private Context mContext;
    private List<Dream> dreamList;
    public DreamAdapter(Context mContext, List<Dream> dreamList){
        this.mContext = mContext;
        this.dreamList = dreamList;
    }

    public void setData( List<Dream> dreamList){
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
        convertView = View.inflate(mContext, R.layout.item_dream,null);
        TextView titleTv = (TextView) convertView.findViewById(R.id.tv_dream_title);
        TextView descTv = (TextView) convertView.findViewById(R.id.tv_dream_desc);

        Dream dream = dreamList.get(position);
        titleTv.setText(TextUtils.isEmpty(dream.title)?dream.desc:dream.title);
        String descStr = "";
        for (String str: dream.list){
            descStr +=str;
            descStr += "\n";
        }
        descTv.setText(descStr);
        return convertView;
    }
}
