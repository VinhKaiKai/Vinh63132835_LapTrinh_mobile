package com.tramquangvinh.tab_selector;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb;
    Button btntong;
    TabHost mytab;
    // khai bao list view
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a+b;
                mylist.add(a + " + " + b + " = " + c); // them du lieu vao mang
                myadapter.notifyDataSetChanged(); // cap nhat lai adapter
            }
        });
    }

    private void addControl() {
        // 3 dong duoi oke
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        btntong = findViewById(R.id.btntong);
        // xu ly list view (4 dong duoi oke)
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();// tao mang
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter); // dua adapter len list view
        // xu ly tabHost
        mytab = findViewById(R.id.mytab);
        mytab.setup();
        // khai bao cac Tab con
        TabHost.TabSpec spec1, spec2;
        // 1 spec thi lam4 cong viec
        // tab 1
        spec1 = mytab.newTabSpec("t1"); // tao moi tab
        spec1.setContent(R.id.tab1); // tham chieu id cho tab1
        spec1.setIndicator("",getResources().getDrawable(R.drawable.cong)); // thiết lập ảnh
        mytab.addTab(spec1);// Thêm cái tab 1 vào tap chính
        // tab 2
        spec2 = mytab.newTabSpec("t2"); // tạo mới tab
        spec2.setContent(R.id.tab2); // tham chieu id cho tab2
        spec2.setIndicator("",getResources().getDrawable(R.drawable.luutru));
        mytab.addTab(spec2);// them tab 1 vao tab chinh
    }
}