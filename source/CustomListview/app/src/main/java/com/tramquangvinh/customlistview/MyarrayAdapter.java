package com.tramquangvinh.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyarrayAdapter extends ArrayAdapter<Bear> {
    Activity context;
    int idlayout;
    ArrayList<Bear> mylist;
    // create constructer to Mainactivity call to and get conStructers


    public MyarrayAdapter( Activity context, int idlayout, ArrayList<Bear> mylist) {
        super(context, idlayout, mylist);
        this.context = context;
        this.idlayout = idlayout;
        this.mylist = mylist;
    }
    // call Ham` get view to accsess arrange datas


    // ghi getV select second + tab
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Tạo cái đế để chứa layout
        LayoutInflater myflater = context.getLayoutInflater();
        // Đặt id layout lên đế để tạo thành 1 đối tượng view
        convertView = myflater.inflate(idlayout, null);
        // Lấy 1 phần tử trong mảng
        Bear myBear = mylist.get(position);
        //Khai báo và tham chiểu id và hiển thị ảnh lên imageview
        ImageView img_bear = convertView.findViewById(R.id.img_kaikai);
        img_bear.setImageResource(myBear.getImage());
        //Khai báo và tham chiếu id và hiển thị tên bear lên textview
        TextView txt_bear = convertView.findViewById(R.id.txt_kaikai);
        txt_bear.setText(myBear.getName());
        return convertView;
    }
}
