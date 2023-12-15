package com.tramquangvinh.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ManNoiDung extends AppCompatActivity {
    TextView txtTenTruyen, txtNoiDung;
    LinearLayout chudechinh;
    ImageButton btncochu, btnchude;
    int cochu = 0;
    int chude = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_noi_dung);
        //anh xa
        txtTenTruyen = findViewById(R.id.TenTruyen);
        chudechinh = findViewById(R.id.chudechinh);
        txtNoiDung = findViewById(R.id.noidung);
        btncochu = findViewById(R.id.chu);
        btnchude = findViewById(R.id.chude);
        // Lấy nội dung được gửi
        Intent intent = getIntent();
        String tentruyen = intent.getStringExtra("tentruyen");
        String noidung = intent.getStringExtra("noidung");
        txtTenTruyen.setText(tentruyen);
        txtNoiDung.setText(noidung);
        //Cho phép cuộn nội dung do dài
        txtNoiDung.setMovementMethod(new ScrollingMovementMethod());

        // xữ lý 2 nút
        btncochu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cochu = cochu + 1;
                if(cochu == 4)
                {
                    cochu = 0;
                }
                if (cochu == 0) {
                    txtNoiDung.setTextSize(20);
                }
                else if (cochu == 1) {
                    txtNoiDung.setTextSize(22);
                }
                else if (cochu == 2) {
                    txtNoiDung.setTextSize(24);
                }
                else if (cochu == 3) {
                    txtNoiDung.setTextSize(26);
                }
            }
        });

        int xanh = getResources().getColor(R.color.blue);
        int do1 = getResources().getColor(R.color.organe2);
        int tim = getResources().getColor(R.color.pink1);
        int vang2 = getResources().getColor(R.color.yellow1);

        int nenc0 = getResources().getColor(R.color.pinkk);
        int chuc1 = getResources().getColor(R.color.black);
        int chuc2 = getResources().getColor(R.color.chuc2);
        int chuc3 = getResources().getColor(R.color.chuc3);
        int xam11 = getResources().getColor(R.color.xam10);
        int nenc2 = getResources().getColor(R.color.xam1);
        int nenc3 = getResources().getColor(R.color.nenc3);
        int xam12 = getResources().getColor(R.color.xam11);
        int vang = getResources().getColor(R.color.organe);
        int vang1 = getResources().getColor(R.color.yellow2);
        btnchude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chude = chude +1;
                if(chude == 4)
                {
                    chude = 0;
                }
                if(chude ==0)
                {
                    txtTenTruyen.setBackgroundColor(nenc0);
                    btncochu.setBackgroundColor(xanh);
                    btnchude.setBackgroundColor(xanh);
                    txtTenTruyen.setTextColor(chuc1);
                    chudechinh.setBackgroundColor(nenc0);
                    txtNoiDung.setTextColor(xam12);
                    txtNoiDung.setBackgroundColor(chuc1);
                    Toast.makeText(ManNoiDung.this, "Màn bình thường",Toast.LENGTH_SHORT).show();
                } else if (chude == 1) {
                    txtTenTruyen.setBackgroundColor(nenc3);
                    chudechinh.setBackgroundColor(nenc3);
                    btncochu.setBackgroundColor(do1);
                    btnchude.setBackgroundColor(do1);
                    txtNoiDung.setTextColor(chuc2);
                    txtNoiDung.setBackgroundColor(nenc2);
                    Toast.makeText(ManNoiDung.this, "Màn sáng vừa",Toast.LENGTH_SHORT).show();
                }
                else if (chude == 2) {
                    txtTenTruyen.setBackgroundColor(xam12);
                    chudechinh.setBackgroundColor(xam12);
                    btncochu.setBackgroundColor(tim);
                    btnchude.setBackgroundColor(tim);
                    txtNoiDung.setTextColor(xam11);
                    txtNoiDung.setBackgroundColor(chuc3);
                    Toast.makeText(ManNoiDung.this, "Màn tối nhẹ",Toast.LENGTH_SHORT).show();
                }
                else if (chude == 3) {
                    txtTenTruyen.setBackgroundColor(chuc1);
                    chudechinh.setBackgroundColor(chuc1);
                    btncochu.setBackgroundColor(vang2);
                    btnchude.setBackgroundColor(vang2);
                    txtNoiDung.setTextColor(vang);
                    txtNoiDung.setBackgroundColor(chuc1);
                    txtTenTruyen.setTextColor(vang1);
                    Toast.makeText(ManNoiDung.this, "Màn tối",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}