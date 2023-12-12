package com.tramquangvinh.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import com.tramquangvinh.ungdungdoctruyen.database.Databasedoctruyen;
import com.tramquangvinh.ungdungdoctruyen.model.TaiKhoan;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManDangKy extends AppCompatActivity {
    Button btnDKDangKy, btnDKDangNhap;
    EditText edtDKTaiKhoan, edtDKMatKhau, edtDKEmail;
    Databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_ky);
        databasedoctruyen = new Databasedoctruyen(this);
        Anhxa();
        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edtDKTaiKhoan.getText().toString().trim();
                String matkhau = edtDKMatKhau.getText().toString().trim();
                String email = edtDKEmail.getText().toString().trim();

                TaiKhoan taikhoan1 = CreateTaiKhoan();
                if(taikhoan.isEmpty() || matkhau.isEmpty() || email.isEmpty())
                {
                    Toast.makeText(ManDangKy.this, "Không được bỏ trống các dữ liệu", Toast.LENGTH_SHORT).show();
                }
                else if(!isValidEmail(email))
                {
                    Toast.makeText(ManDangKy.this, "Sai định dạng Email", Toast.LENGTH_SHORT).show();
                    edtDKEmail.setText("");
                    edtDKEmail.requestFocus();
                }
                else {
                    databasedoctruyen.AddTaiKhoan(taikhoan1);
                    Toast.makeText(ManDangKy.this, "đăng ký thành công", Toast.LENGTH_LONG).show();

                    Log.e("Thông báo", "Tạo tài khoản thành công");
                }
            }
        });
        btnDKDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean isValidEmail(String email) {
        // Sử dụng biểu thức chính quy để kiểm tra định dạng email
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    // Tao taiKhoan
    private TaiKhoan CreateTaiKhoan()
    {
        String taikhoan = edtDKTaiKhoan.getText().toString();
        String matkhau = edtDKMatKhau.getText().toString();
        String email = edtDKEmail.getText().toString();
        int phanquyen = 1;
        TaiKhoan tk = new TaiKhoan(taikhoan, matkhau, email, phanquyen);
        return  tk;

    }
    private void Anhxa() {
        edtDKEmail= findViewById(R.id.dkemail);
        edtDKMatKhau= findViewById(R.id.dkmatkhau);
        edtDKTaiKhoan= findViewById(R.id.dktaikhoan);
        btnDKDangKy= findViewById(R.id.dkdangky);
        btnDKDangNhap= findViewById(R.id.dkdangnhap);

    }
}