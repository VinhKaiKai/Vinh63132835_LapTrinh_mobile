package com.tramquangvinh.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import com.tramquangvinh.ungdungdoctruyen.adapter.adapterTruyen;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.tramquangvinh.ungdungdoctruyen.database.Databasedoctruyen;
import com.tramquangvinh.ungdungdoctruyen.model.Truyen;

import java.util.ArrayList;

public class ManTimKiem extends AppCompatActivity {
    ListView listView;
    EditText edt;
    ArrayList<Truyen> TruyenArraylist;
    ArrayList<Truyen> arrayList;
    adapterTruyen adapterTruyen;
    Databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_tim_kiem);

        listView = findViewById(R.id.listviewtimkiem);
        edt = findViewById(R.id.timkiem);

        initList(); // hiển thị danh sách tuyện lên
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override // list tuyện từ màn hình tìm kiếm
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(ManTimKiem.this, ManNoiDung.class);
                String tent = arrayList.get(position).getTenTruyen();
                String noidungt= arrayList.get(position).getNoiDung();
                intent.putExtra("tentruyen", tent);
                intent.putExtra("noidung",noidungt);
                startActivity(intent);
            }
        });
        edt.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Phương thức này được gọi để thông báo rằng có sự thay đổi trong văn bản trước khi thực sự thay đổi.
                // Thông thường, bạn có thể không sử dụng phương thức này, và nó để trống.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Phương thức này được gọi để thông báo rằng có sự thay đổi trong văn bản ngay khi nó xảy ra.
                // Trong phương thức này, bạn có thể thực hiện các xử lý ngay sau khi văn bản thay đổi
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }
    //search
    private void filter(String text)
    {
        // Xóa dữ liệu mảng
        arrayList.clear();
        // Tạo một danh sách mới để lưu trữ các đối tượng Truyen sau khi lọc
        ArrayList<Truyen> filteredList = new ArrayList<>();
        // Duyệt qua danh sách gốc TruyenArraylist
        for(Truyen item : TruyenArraylist)
        {
            // Kiểm tra nếu tên của mỗi Truyen chứa phần của văn bản tìm kiếm (text)
            if(item.getTenTruyen().toLowerCase().contains(text.toLowerCase()))
            {
                // THêm đối tượng Truyen vào danh sách filteredList
                filteredList.add(item);
                // Thêm đối tượng Truyen vào mảng arrayList để hiển thị trong giao diện người dùng
                arrayList.add(item);
            }
        }
        adapterTruyen.filterList(filteredList);
    }

    // truyền dữ liệu truyện từ database vào listview hiển thị trên màn hình
    private void initList() {
        TruyenArraylist = new ArrayList<>();
        arrayList = new ArrayList<>();
        databasedoctruyen = new Databasedoctruyen(this);
        Cursor cursor = databasedoctruyen.getData2();
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String tentruyen = cursor.getString(1);
            String noidung = cursor.getString(2);
            String anh = cursor.getString(3);
            int id_tk = cursor.getInt(4);
            TruyenArraylist.add(new Truyen(id,tentruyen,noidung,anh,id_tk));
            arrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));
            adapterTruyen = new adapterTruyen(getApplicationContext(),TruyenArraylist);
            listView.setAdapter(adapterTruyen);
        }
        cursor.moveToFirst();
        cursor.close();
    }
}