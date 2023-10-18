package com.tramquangvinh.constain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến giao diện
    EditText edt1 , edt2, edt3;
    Button btnTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ nối các biến với các id đã có trong giao diện
        edt1 = findViewById(R.id.edtA);
        edt2 = findViewById(R.id.edtB);
        edt3 = findViewById(R.id.edt3);
        btnTong = findViewById(R.id.edtkq);
        //xử lý click vào nút kết quả màu xanh
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int a = edt1.getText().toString();
                int a = Integer.parseInt(edt1.getText().toString()); // vì sài edittext nên nó chỉ có dữ liệu nhập vô là string nên ép sang string trước rồi ép kiểu int sau
                int b = Integer.parseInt(edt2.getText().toString()); // lay du lieu roi ep kieu sang kieu int roi gan vo bien a
                int c = a+b;
                edt3.setText(c+""); //  nó chỉ hiển thị 1 chuổi trên edittext nên phải cộng vs 1 chuổi rổng để chuyển
            }
        });
    }
}