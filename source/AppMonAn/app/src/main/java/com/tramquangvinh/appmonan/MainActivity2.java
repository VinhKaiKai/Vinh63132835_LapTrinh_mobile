package com.tramquangvinh.appmonan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtview = findViewById(R.id.tenmonan);
        // nhận intent
        Intent myintent = getIntent();
        // lay du lieu
        String name = myintent.getStringExtra("vinh");
        txtview.setText(name);
    }
}