package com.tramquangvinh.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import com.tramquangvinh.ungdungdoctruyen.database.Databasedoctruyen;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManDangNhap extends AppCompatActivity {

    Button btnDangKy , btnDangNhap;
    EditText edtTaiKhoan, edtMatKhau;
    Databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_nhap);
        Anhxa();
        databasedoctruyen = new Databasedoctruyen(this);

        // nút đăng ký
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ManDangNhap.this, ManDangKy.class);
                startActivity(intent);
            }
        });
        // nút đăng nhập
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy dữ liệu 2 cái khung nhập
                String tentaikhoan = edtTaiKhoan.getText().toString();
                String matkhau = edtMatKhau.getText().toString();
                Cursor cursor = databasedoctruyen.getData();
                // chạy csdl trong databasedoctruyen
                while (cursor.moveToNext())
                {
                    String datatentaikhoan = cursor.getString(1);
                    String datamatkhau = cursor.getString(2);

                    if(datatentaikhoan.equals(tentaikhoan) && datamatkhau.equals(matkhau))
                    {
                        int phanquyen = cursor.getInt(4);
                        int idd = cursor.getInt(0);
                        String email = cursor.getString(3);
                        String tentk = cursor.getString(1);

                        Intent intent = new Intent(ManDangNhap.this, ManChinh.class);
                        // gửi dữ liệu qua
                        intent.putExtra("phanq",phanquyen);
                        intent.putExtra("idd",idd);
                        intent.putExtra("email",email);
                        intent.putExtra("tentaikhoan",tentk);
                        startActivity(intent);

                    }
                }
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }

    private void Anhxa() {
        edtMatKhau = findViewById(R.id.matkhau);
        edtTaiKhoan = findViewById(R.id.taikhoan);
        btnDangKy = findViewById(R.id.dangky);
        btnDangNhap = findViewById(R.id.dangnhap);


    }
}