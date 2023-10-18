package com.tramquangvinh.intentchuyendulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btnkq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ÁNH XẠ
        edtA = findViewById(R.id.edta);
        edtB = findViewById(R.id.edtb);
        btnkq = findViewById(R.id.btnkq);
        // xử lý click
        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khai báo Intent
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                // Đóng gói dữ liệu vào Bundle
                Bundle mybundle = new Bundle();
                // đưa dữ liệu vô
                mybundle.putInt("soa",a);
                mybundle.putInt("sob",b);
                // đưa bundle vào intent vì 1 intent chứa nhiều bundle nên cũng phải có name cho bundle
                myintent.putExtra("mypackage", mybundle);
                // khởi động
                startActivity(myintent);
            }
        });

    }
}