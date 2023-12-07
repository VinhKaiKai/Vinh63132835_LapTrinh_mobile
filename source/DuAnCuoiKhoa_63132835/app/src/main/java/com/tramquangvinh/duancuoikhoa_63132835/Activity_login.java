package com.tramquangvinh.duancuoikhoa_63132835;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tramquangvinh.duancuoikhoa_63132835.database.databasedoctruyen;


public class Activity_login extends AppCompatActivity {
    TextView  txtforgotpassword;
    Button btnregister , btnlogin;
    EditText edtusername, edtpassword;
    databasedoctruyen databasedoctruyen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // ánh xạ
        txtforgotpassword = findViewById(R.id.txtforgotpassword);
        btnregister = findViewById(R.id.btnregister);
        btnlogin = findViewById(R.id.btnlogin);
        edtusername = findViewById(R.id.edtUserName);
        edtpassword = findViewById(R.id.edtPassWord);
        databasedoctruyen = new databasedoctruyen(this);



       btnlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // Lấy giá trị từ 2 cái edittext vô
               String tentaikhoan = edtusername.getText().toString();
               String matkhau = edtpassword.getText().toString();

               //dùng con trỏ để lấy dữ liệu từ data
               Cursor cursor = databasedoctruyen.getData();

               // Thực hiện  vòng lập để đi hết vong đời của dữ liệu.
               while(cursor.moveToNext())
               {
                   // Lấy dữ liệu từ cột 1 của dữ liệu tài khoản
                   String datatentaikhoan = cursor.getString(1);
                   String datatenmatkhau= cursor.getString(2);

                   if(datatentaikhoan.equals(tentaikhoan) && datatenmatkhau.equals(matkhau))
                   {
                       //Lấy dữ liệu phân quyền và id
                       int phanquyen = cursor.getInt(4);
                       int id= cursor.getInt(0);
                       String email = cursor.getString(3);
                       String tentk = cursor.getString(1);

                       Intent myintern1 = new Intent(Activity_login.this, activity_vip.class);

                       myintern1.putExtra("phanquyen", phanquyen);
                       myintern1.putExtra("id", id);
                       myintern1.putExtra("email", email);
                       myintern1.putExtra("tentaikhoan", tentk);

                       startActivity(myintern1);
                   }
                   else if(edtusername.getText().toString().equals("") && edtpassword.getText().toString().equals(""))
                   {
                       Toast.makeText(Activity_login.this, "Account or Password is Wrong!!!", Toast.LENGTH_SHORT).show();
                   }
               }
               // Trả con trỏ về lại dòng đầu.
               cursor.moveToFirst();
               cursor.close();
           }
       });

        // chuyển trang tới trang đăng ký
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