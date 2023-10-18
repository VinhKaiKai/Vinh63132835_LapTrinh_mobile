package com.tramquangvinh.intentchuyendulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txtnghiem;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtnghiem = findViewById(R.id.txtda);
        btnback = findViewById(R.id.btnback);
        //nhận diện tên tạo ra đối tượng để lấy thôi bắt buột
        Intent myintent1 = getIntent();
        //lấy bundle từ đối tượng tạo ra đó là myintent1 và lấy thông qua name bundle
        Bundle mybundle1 = myintent1.getBundleExtra("mypackage");
        // lấy dữ liệu
        int a = mybundle1.getInt("soa");
        int b = mybundle1.getInt("sob");
        String nghiem = "";
        // giai pt
        if(a==0 && b==0){
            nghiem = "Vô số nghiệm";
        }
        else if(a==0 && b!=0){
            nghiem ="Phương trình vô nghiệm";
        }
        else{
            nghiem= " Nghiệm PT là: " +(-1.0) * b/a;
        }
        txtnghiem.setText(nghiem);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //back main
            }
        });
    }
}