package com.tramquangvinh.appmonan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tim listview Ánh xạ
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvdsmonan);
        // Chuẩn bị nguồn dữ liệu
        ArrayList<MonAn> dsmonan = new ArrayList<>();
        MonAn m1 = new MonAn("Cơm tắm sườn", 25000, "đây là món ăn ngon",R.drawable.monan1);
        MonAn m2 = new MonAn("Sushi", 26000, "đây là món ăn ngon 2",R.drawable.monan2);
        MonAn m3 = new MonAn("Món 3", 27000, "đây là món ăn ngon 3",R.drawable.monan3);
        MonAn m4 = new MonAn("Cơm món", 28000, "đây là món ăn ngon 4",R.drawable.monan4);
        MonAn m5 = new MonAn("Cơm tắm ", 29000, "đây là món ăn ngon 5",R.drawable.monan5);
        dsmonan.add(m1);
        dsmonan.add(m2);
        dsmonan.add(m3);
        dsmonan.add(m4);
        dsmonan.add(m5);
        //Tạo adapter
        MonAnAdapter adapter = new MonAnAdapter(this,dsmonan);
        lvDSMonAn.setAdapter(adapter);
        // bat xu ly
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MonAn monanchon = dsmonan.get(i);
                Toast.makeText(MainActivity.this, monanchon.getTenMonAn() , Toast.LENGTH_SHORT).show();
                Intent myintent = new Intent(MainActivity.this , MainActivity2.class);
                myintent.putExtra("vinh", monanchon.getTenMonAn());
                startActivity(myintent);
            }
        });


    }
}