package com.tramquangvinh.duancuoikhoa_63132835;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Activity_signup extends AppCompatActivity {

    Button btnback, btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnback = findViewById(R.id.btnback);
        btnsignup = findViewById(R.id.btnsignup);



    }
}