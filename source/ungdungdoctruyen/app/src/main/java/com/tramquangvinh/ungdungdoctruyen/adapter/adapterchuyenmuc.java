package com.tramquangvinh.ungdungdoctruyen.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tramquangvinh.ungdungdoctruyen.R;
import com.tramquangvinh.ungdungdoctruyen.model.chuyenmuc;

import java.util.List;

public class adapterchuyenmuc extends BaseAdapter {
    private Context context;
    private int layout;
    private List<chuyenmuc> chuyenmucList;

    public adapterchuyenmuc(Context context, int layout, List<chuyenmuc> chuyenmucList) {
        this.context = context;
        this.layout = layout;
        this.chuyenmucList = chuyenmucList;
    }

    @Override
    public int getCount() {
        return chuyenmucList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // hiển thị các chuyên mục chức năng của menu
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Lấy LayoutInflater từ Context để chuyển đổi layout thành View
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        // Lấy các thành phần UI từ convertView
        ImageView img = (ImageView) convertView.findViewById(R.id.imgchuyenmuc);
        TextView txt = (TextView) convertView.findViewById(R.id.textviewTenchuyenmuc);
        chuyenmuc cm = chuyenmucList.get(position);
        // Thiết lập dữ liệu cho các thành phần UI từ đối tượng chuyenmuc
        txt.setText(cm.getTenchuyenmuc());
        Picasso.get().load(cm.getHinhanhchuyenmuc()).placeholder(R.drawable.ic_load).error(R.drawable.chucnang2).into(img);
        return convertView;
    }
}
