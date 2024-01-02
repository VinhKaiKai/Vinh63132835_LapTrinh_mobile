package com.tramquangvinh.ungdungdoctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.tramquangvinh.ungdungdoctruyen.model.Truyen;
import com.tramquangvinh.ungdungdoctruyen.R;
import java.util.ArrayList;

public class adapterTruyen extends BaseAdapter {
    private Context context;
    private ArrayList<Truyen> listTruyen;

    public adapterTruyen(Context context, ArrayList<Truyen> listTruyen) {
        this.context = context;
        this.listTruyen = listTruyen;
    }

    @Override
    public int getCount() {
        return listTruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return listTruyen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

// filter
    public void filterList(ArrayList<Truyen> filteredList) {
        listTruyen = filteredList;
        notifyDataSetChanged();
    }

    public class  ViewHolder{
        TextView txtTenTruyen;
        ImageView imgTruyen;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Tạo một đối tượng ViewHolder để lưu trữ các thành phần của mỗi item trong danh sách.
        ViewHolder viewHolder = null;
        // Kiểm tra nếu convertView đã được tạo trước đó, nếu chưa thì tạo mới và khởi tạo ViewHolder.
        viewHolder = new ViewHolder();
        // Sử dụng LayoutInflater để tạo ra một View từ layout được định nghĩa trong R.layout.newtruyen.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.newtruyen,null);
        // Ánh xạ các thành phần trong item layout đến các thuộc tính của ViewHolder.
        viewHolder.txtTenTruyen = convertView.findViewById(R.id.textviewTenTruyenNew);
        viewHolder.imgTruyen = convertView.findViewById(R.id.imgNewTruyen);
        convertView.setTag(viewHolder);
        // Lấy đối tượng Truyen tại vị trí position trong danh sách dữ liệu.
        Truyen truyen = (Truyen) getItem(position);
        // Đặt dữ liệu cho các thành phần của ViewHolder dựa trên đối tượng Truyen hiện tại.
        viewHolder.txtTenTruyen.setText(truyen.getTenTruyen());
        // Sử dụng thư viện Picasso để tải hình ảnh từ URL và hiển thị trong ImageView.
        Picasso.get().load(truyen.getAnh()).placeholder(R.drawable.ic_load).error(R.drawable.ic_image).into(viewHolder.imgTruyen);
        return convertView;
    }
}
