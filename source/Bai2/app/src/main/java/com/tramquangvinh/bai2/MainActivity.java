package com.tramquangvinh.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity {

    //Khai báo các biến giao diện
    EditText edtF, edtC;
    Button btnC, btnF, btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ các
        edtC = findViewById(R.id.edtc);
        edtF = findViewById(R.id.edtF);
        btnC = findViewById(R.id.btnC);
        btnF = findViewById(R.id.btnF);
        btnClear = findViewById(R.id.btnClear);
        // xử lý tương tác click
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // from C to F
                int c = Integer.parseInt(edtF.getText().toString());
                Double F = c * 1.8 +32;
                edtC.setText(F+"");
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // from F to C
                int f = Integer.parseInt(edtC.getText().toString());
                Double C = (f - 32) * 1.8 ;
                edtF.setText(C+"");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
            }
        });


    }
}