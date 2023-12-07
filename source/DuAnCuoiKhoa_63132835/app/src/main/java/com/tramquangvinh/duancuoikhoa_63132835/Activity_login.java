package com.tramquangvinh.duancuoikhoa_63132835;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class Activity_login extends AppCompatActivity {
    TextView  txtforgotpassword;
    Button btnregister , btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtforgotpassword = findViewById(R.id.txtforgotpassword);
        btnregister = findViewById(R.id.btnregister);
        btnlogin = findViewById(R.id.btnlogin);


        btnlogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action1 = event.getActionMasked();
                switch (action1)
                {
                    case MotionEvent.ACTION_DOWN:
                        btnlogin.setTextColor(Color.RED);
                        return true;
                    case MotionEvent.ACTION_UP:
                        btnlogin.setTextColor(Color.GRAY);
                        return true;
                }
                return false;
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_login.this, Activity_signup.class);
                startActivity(myIntent);
            }
        });
       txtforgotpassword.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               int action1 = event.getActionMasked();
               switch (action1)
               {
                   case MotionEvent.ACTION_DOWN:
                       txtforgotpassword.setTextColor(Color.RED);
                       return true;
                   case MotionEvent.ACTION_UP:
                       txtforgotpassword.setTextColor(Color.WHITE);
                       return true;
               }
               return false;
           }
       });



    }
}