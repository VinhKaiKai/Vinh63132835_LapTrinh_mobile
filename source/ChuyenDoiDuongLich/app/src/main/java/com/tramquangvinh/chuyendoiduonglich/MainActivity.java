package com.tramquangvinh.chuyendoiduonglich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // anh xa
    EditText edtduonglich;
    Button btnchuyen;
    TextView txtamlich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa
        edtduonglich = findViewById(R.id.edtduonglich2023);
        btnchuyen = findViewById(R.id.btnchuyendoi);
        txtamlich = findViewById(R.id.txtamLich);
        btnchuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String can ="", chi ="";
                int namduong = Integer.parseInt(edtduonglich.getText().toString());
                switch (namduong%10)
                {
                    case 0: can ="Canh";
                    break;
                    case 1: can ="Tân";
                        break;
                    case 2: can ="Nhâm";
                        break;
                    case 3: can ="Quý";
                        break;
                    case 4: can ="Giáp";
                        break;
                    case 5: can ="Ất";
                        break;
                    case 6: can ="Bính";
                        break;
                    case 7: can ="Đình";
                        break;
                    case 8: can ="Mậu";
                        break;
                    case 9: can ="Kỷ";
                        break;
                }
                switch (namduong%12)
                {
                    case 0: chi= "Thân";break;
                    case 1: chi= "Dậu";break;
                    case 2: chi= "Tuất";break;
                    case 3: chi= "Hợi";break;
                    case 4: chi= "Tí";break;
                    case 5: chi= "Sửu";break;
                    case 6: chi= "Dần";break;
                    case 7: chi= "Mão";break;
                    case 8: chi= "Thìn";break;
                    case 9: chi= "Tị";break;
                    case 10: chi= "Ngọ";break;
                    case 11: chi= "Bùi";break;
                }
                txtamlich.setText(can+" "+chi);
            }
        });


    }
}