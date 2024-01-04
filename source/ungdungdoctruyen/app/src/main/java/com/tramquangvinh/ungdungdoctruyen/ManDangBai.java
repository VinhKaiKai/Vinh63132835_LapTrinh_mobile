package com.tramquangvinh.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tramquangvinh.ungdungdoctruyen.database.Databasedoctruyen;
import com.tramquangvinh.ungdungdoctruyen.model.Truyen;

public class ManDangBai extends AppCompatActivity {
    EditText edtTenTruyen, edtNoiDung , edtAnh;
    Button btnDangBai;
    Databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_bai);

        edtAnh = findViewById(R.id.dbimg);
        edtTenTruyen = findViewById(R.id.dbTentruyen);
        edtNoiDung = findViewById(R.id.dbnoidung);
        btnDangBai = findViewById(R.id.dbdangbai);
        databasedoctruyen = new Databasedoctruyen(this);

        // nút đăng bài xác nhận
        btnDangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy các trường thông tin vào
                String tentruyen = edtTenTruyen.getText().toString();
                String noidung = edtNoiDung.getText().toString();
                String img = edtAnh.getText().toString();

                Truyen truyen = CreateTruyen();
                // xử lý nếu các trường rổng thì không cho đăng bài
                if(tentruyen.equals("") || noidung.equals("") || img.equals(""))
                {
                    Toast.makeText(ManDangBai.this, "Nhập đủ mới được đăng!", Toast.LENGTH_SHORT).show();
                    Log.e("ERR :","Nhập đầy đủ thông tin");
                }
                // Nếu nhập đủ thông tin thì thực hiện
                else{
                    databasedoctruyen.AddTruyen(truyen);
                    // Chuyển qua màn hình admin và cập nhật lại dữ liệu
                    Intent intent = new Intent(ManDangBai.this, ManAdmin.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    // hàm tạo tuyện
    private Truyen CreateTruyen()
    {
        String tentruyen = edtTenTruyen.getText().toString();
        String noidung = edtNoiDung.getText().toString();
        String img = edtAnh.getText().toString();
        Intent intent = getIntent();
        int id = intent.getIntExtra("Id",0);
        Truyen truyen = new Truyen(tentruyen,noidung,img,id);
        return  truyen;
    }
}