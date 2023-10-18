package com.tramquangvinh.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // anh xa
    Button nutxacnhan;
    EditText edttk, edtmk;
    String taikhoan = "63clc1";
    String matkhau = String.valueOf(123);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String chuoi = "Login Success!";
        String chuoi2 ="Login Not Sucess!";
        // anh xa
        nutxacnhan = findViewById(R.id.btnxacnhan);
        edttk = findViewById(R.id.edtacount);
        edtmk = findViewById(R.id.edtpassword);

        nutxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dulieutaikhoan = String.valueOf(edttk.getText());
                String dulieumatkhau = String.valueOf(edtmk.getText());
                if(dulieutaikhoan.equals(taikhoan) && dulieumatkhau.equals(matkhau)){
                    Toast.makeText(MainActivity.this,chuoi,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,chuoi2,Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}