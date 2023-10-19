package com.tramquangvinh.nghenhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnplay, btnstop;
    Boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnplay = findViewById(R.id.btnplay);
        btnstop = findViewById(R.id.btnstop);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khai bao intent cong khai de khoi dong service
                Intent intent1 = new Intent(MainActivity.this, MyService.class);
                startService(intent1);//chạy
                // thay doi anh
                if(flag == true){
                    btnplay.setImageResource(R.drawable.stop); // chạy nhạc là true hết. khi mà true mà đc nhấn vô thì dừng nhạc và nó thành flase
                    flag = false;
                }
                else {
                    btnplay.setImageResource(R.drawable.play);// nhạc dừng mà đc nhấn vô nó sẽ đổi ảnh mà biến thành true
                    flag = true;

                }
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khai bao intent cong khai de khoi dong service
                Intent intent2 = new Intent(MainActivity.this, MyService.class);
                stopService(intent2);//Đóng
                btnplay.setImageResource(R.drawable.play);// nhạc dừng mà đc nhấn vô nó sẽ đổi ảnh mà biến thành true
                flag = true;
            }
        });
    }
}