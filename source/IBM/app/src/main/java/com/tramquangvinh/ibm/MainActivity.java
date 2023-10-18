package com.tramquangvinh.ibm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnTinh;
    EditText edtH, edtW;
    TextView tinhT, diemSo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        tinhT = findViewById(R.id.tinhTrang);
        diemSo = findViewById(R.id.diemSo);
        edtH = findViewById(R.id.edtH);
        edtW = findViewById(R.id.edtW);
        btnTinh = findViewById(R.id.btnTinh);
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int canNang = Integer.parseInt(edtW.getText().toString());
                int chieuCao= Integer.parseInt(edtH.getText().toString());
                // Chuyển đổi từ Cm sang m
                double edtHm = chieuCao/100f;
                Double BMI = Double.valueOf(canNang /(edtHm * edtHm));
                if(BMI < 18.5){
                    tinhT.setText("Gầy Quá !");
                } else if (BMI >=18.5 && BMI <=25) {
                    tinhT.setText("太漂亮了");
                }else{
                    tinhT.setText("fater !");
                }
                diemSo.setText("你的BMI:"+BMI);

            }
        });

    }
}