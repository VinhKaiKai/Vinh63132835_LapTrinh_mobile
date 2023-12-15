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
        edt= findViewById(R.id.timkiem);

        initList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(ManTimKiem.this, ManNoiDung.class);
                String tent = arrayList.get(position).getTenTruyen();
                String noidungt= arrayList.get(position).getNoiDung();
                intent.putExtra("tentruyen", tent);
                intent.putExtra("noidung",noidungt);
                startActivity(intent);
            }
        });
        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

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
        // xoa du lieu mang
        arrayList.clear();
        ArrayList<Truyen> filteredList = new ArrayList<>();

        for(Truyen item : TruyenArraylist)
        {
            if(item.getTenTruyen().toLowerCase().contains(text.toLowerCase()))
            {
                // them item vao filterlist
                filteredList.add(item);
                // them vao mang
                arrayList.add(item);

            }
        }
        adapterTruyen.filterList(filteredList);
    }

    // phuong thuc lay du lieu vao listview
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