package com.tramquangvinh.ungdungdoctruyen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;

import com.tramquangvinh.ungdungdoctruyen.R;
import com.tramquangvinh.ungdungdoctruyen.model.TaiKhoan;

import java.util.List;

public class adapterthongtin extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<TaiKhoan> taiKhoanList;

    public adapterthongtin(Context context, int layout, List<TaiKhoan> taiKhoanList) {
        this.context = context;
        this.layout = layout;
        this.taiKhoanList = taiKhoanList;
    }

    @Override
    public int getCount() {
        return taiKhoanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    // hiện thông tin đã nhận vào cái layout này
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        // Ánh xạ các thành phần trong layout của mỗi item với các biến.
        TextView txtTenTaiKhoan = (TextView) convertView.findViewById(R.id.TEXT_NAME);
        TextView txtEmail = (TextView) convertView.findViewById(R.id.TEXT_Email);
        // Lấy đối tượng TaiKhoan tương ứng với vị trí position trong danh sách dữ liệu.
        TaiKhoan taiKhoan = taiKhoanList.get(position);
        // Đặt dữ liệu cho TextViews của item dựa trên thông tin từ đối tượng TaiKhoan.
        txtTenTaiKhoan.setText(taiKhoan.getmTenTaiKhoan());
        txtEmail.setText(taiKhoan.getmEmail());
        return convertView;
    }
}
