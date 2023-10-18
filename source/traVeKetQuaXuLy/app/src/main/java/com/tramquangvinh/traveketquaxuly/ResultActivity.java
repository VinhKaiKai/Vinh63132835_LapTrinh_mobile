package com.tramquangvinh.traveketquaxuly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    EditText edtnhan;
    Button btngoc, btnbp;
    Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        edtnhan = findViewById(R.id.edtnhan);
        btngoc = findViewById(R.id.btngoc);
        btnbp = findViewById(R.id.btnbp);
        //Nhận INTENT
        myintent = getIntent();
        // Lấy dữ liệu khỏi Intent
        int a = myintent.getIntExtra("soa", 0); // so 0 là khi lấy số a ko thành công nó sẽ biến số đó thành số 0
        // Hiển thị nó lên trên khung
        edtnhan.setText(""+a);
        // sự kiện click gốc
        btngoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent.putExtra("kq",a+10);
                setResult(33,myintent);
                finish();
            }
        });
        btnbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent.putExtra("kq",a*a);
                setResult(34,myintent);
                finish();
            }
        });

    }
}