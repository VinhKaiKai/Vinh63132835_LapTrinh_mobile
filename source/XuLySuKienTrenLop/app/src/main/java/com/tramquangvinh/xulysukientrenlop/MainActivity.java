package com.tramquangvinh.xulysukientrenlop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // anh xa
    Button nut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nut = findViewById(R.id.btnok);
        nut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi = "xin chao";
                Toast.makeText(MainActivity.this,chuoi,Toast.LENGTH_LONG).show();
            }
        });

    }
}