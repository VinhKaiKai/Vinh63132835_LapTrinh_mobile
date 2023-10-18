package com.tramquangvinh.hocadaptertrenlop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Khai bao nguon du lieu
    AutoCompleteTextView auTV;
    ArrayList<String> COUNTRY = new ArrayList<String>(); // step 0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        //step 0 continues add data
        COUNTRY.add("Việt Nam");
        COUNTRY.add("Thái Lan");
        COUNTRY.add("Trung Quốc");
        COUNTRY.add("Anh Quốc");
        COUNTRY.add("CamPuChia");
        COUNTRY.add("Laos");
        COUNTRY.add("Indonesia");
        COUNTRY.add("USA");
        COUNTRY.add("Myanmar");
        COUNTRY.add("Singapor");
        // step 2
        ArrayAdapter<String> adaptercountry = new ArrayAdapter<String>(
          this,android.R.layout.simple_dropdown_item_1line,
          COUNTRY // generic data to display
        );
        auTV.setAdapter(adaptercountry);
    }
    // step 3
    public void getWidget(){
        auTV = findViewById(R.id.autotext);
    }
}