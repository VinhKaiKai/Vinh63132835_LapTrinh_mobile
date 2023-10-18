package com.tramquangvinh.customlistviewflag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> dsQG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsQG = new ArrayList<Country>();
        Country qg1 = new Country("VietNam", "vienam" ,800000);
        Country qg2 = new Country("USA", "trungquoc" ,900000);
        Country qg3 = new Country("UK", "my" ,50000);
        dsQG.add(qg1);
        dsQG.add(qg2);
        dsQG.add(qg3);
        // tim dieu khien
        ListView lvQG = findViewById(R.id.listviewnation);
        // tao adapter
        CountryArrayAdapter adapter;
        adapter = new CountryArrayAdapter(dsQG, this);
        // gan vao adapter
        lvQG.setAdapter(adapter);
        // xuly su kien

    }
}