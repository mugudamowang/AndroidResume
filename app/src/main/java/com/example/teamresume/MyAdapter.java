package com.example.teamresume;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<HashMap<String, Object>> listItem;

    public MyAdapter(Context context, ArrayList<HashMap<String, Object>> listItem) {
        this.mInflater = LayoutInflater.from(context);
        this.listItem = listItem;
    }//声明构造函数

    @Override
    public int getCount() {
        return listItem.size();
    }//这个方法返回了在适配器中所代表的数据集合的条目数

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }//这个方法返回了数据集合中与指定索引position对应的数据项

    @Override
    public long getItemId(int position) {
        return position;
    }//这个方法返回了在列表中与指定索引对应的行id



    //listview + viewholder 列表优化组合
    static class ViewHolder
    {
        public ImageView img;   //头像
        public TextView title;  //头衔
        public TextView remark; //寄语
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item, null);       //加载单行布局
            holder.img = (ImageView)convertView.findViewById(R.id.ItemImage);
            holder.title = (TextView)convertView.findViewById(R.id.ItemTitle);
            holder.remark = (TextView)convertView.findViewById(R.id.ItemRemark);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.img.setImageResource((Integer) listItem.get(position).get("ItemImage"));
        holder.title.setText((String) listItem.get(position).get("ItemName"));
        holder.remark.setText((String) listItem.get(position).get("ItemRemark"));

        return convertView;
    }
}
