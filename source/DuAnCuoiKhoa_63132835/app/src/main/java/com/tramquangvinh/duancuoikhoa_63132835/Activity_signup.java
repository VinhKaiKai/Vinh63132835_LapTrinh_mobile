package com.tramquangvinh.duancuoikhoa_63132835;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.tramquangvinh.duancuoikhoa_63132835.database.databasedoctruyen;
import android.widget.EditText;
import android.widget.Toast;

import com.tramquangvinh.duancuoikhoa_63132835.model.TaiKhoan;

public class Activity_signup extends AppCompatActivity {

    Button btnback, btnsignup;
    EditText edtAccount, edtPassword, edtEmail;
    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // ANH XA
        btnback = findViewById(R.id.btnback);
        btnsignup = findViewById(R.id.btnsignup);
        edtAccount = findViewById(R.id.edtAccount);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        databasedoctruyen = new databasedoctruyen(this);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = edtAccount.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                TaiKhoan taikhoan1 = CreateTaiKhoan();
                if(account.isEmpty() || password.isEmpty() || email.isEmpty())
                {
                    Toast.makeText(Activity_signup.this, "Không được bỏ trống các dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else if(!isValidEmail(email))
                {
                    Toast.makeText(Activity_signup.this, "Sai định dạng Email", Toast.LENGTH_SHORT).show();
                    edtEmail.setText("");
                    edtEmail.requestFocus();
                }
                else {
                    databasedoctruyen.AddTaiKhoan(taikhoan1);
                    Toast.makeText(Activity_signup.this, "đăng ký thành công", Toast.LENGTH_LONG).show();

                    Log.e("Thông báo", "Tạo tài khoản thành công");
                }

            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_signup.this, Activity_login.class);
                startActivity(myIntent);
            }
        });
    }


    // định dạng email.


    private boolean isValidEmail(String email) {
        // Sử dụng biểu thức chính quy để kiểm tra định dạng email
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    // Tao taiKhoan
    private TaiKhoan CreateTaiKhoan()
    {
        String taikhoan = edtAccount.getText().toString();
        String matkhau = edtAccount.getText().toString();
        String email = edtAccount.getText().toString();
        int phanquyen = 1;
        TaiKhoan tk = new TaiKhoan(taikhoan, matkhau, email, phanquyen);
        return  tk;

    }
}