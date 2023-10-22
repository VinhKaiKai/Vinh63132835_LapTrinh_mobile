package com.tramquangvinh.chuyendulieuintentdongian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnmain ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmain = findViewById(R.id.btnMain);
        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, MainActivity2.class);

                //Chuyển chuổi String
                myintent.putExtra("dulieu","Tao là TRẦM QUANG VINH LỚP 63CNTTCLC1");// gửi nội dung với cái name khi bên nhận muốn nhận phải đúng cái name mới cho nhận

                // chuyển số int
                int soint = 2808;
                myintent.putExtra("dulieu2",soint);

                // chuyển 1 mảng dữ liệu String
                String[] mangCuaToi = {"Vinh", "Lập", "Quân", "Huy"};
                myintent.putExtra("dulieu3", mangCuaToi);


                // chuyển từ 1 đối tượng tạo class sinh viên
                SinhVien sv = new SinhVien("Vinh", 20 , "Nha Trang");
                myintent.putExtra("dulieu4", sv);


                String[] mangchobundle = {"nha trang", "ha noi", "tphcm"};
                // Kiều dữ liệu BUNDLE: kiểu mà gửi 1 đống dữ liệu qua bên kia. khi sử dụng thì tách nó ra và dùng
                // b1 tạo 1 bundle
                Bundle mybundle = new Bundle();
                // đưa dữ liệu vào bundle thì dùng PUT
                mybundle.putString("chuoi", "Tram quang ving"); // chưa chuổi
                mybundle.putInt("conso",123); // chứa kiểu int
                mybundle.putStringArray("arrayne", mangchobundle); // chứa mảng
                mybundle.putSerializable("hocsinhne",sv);// chứa đối tượng
                // Nhưng mà nó muốn gữi thì nó vẫn cần đến INTENT vì vậy mình tạo ra cái gói lớn bundle rồi giờ gửi dữ liệu trong bundel đi
                myintent.putExtra("dulieucuabundle", mybundle);


                startActivity(myintent);// luôn luôn để cái này ở dưới cùng
            }
        });
    }
}