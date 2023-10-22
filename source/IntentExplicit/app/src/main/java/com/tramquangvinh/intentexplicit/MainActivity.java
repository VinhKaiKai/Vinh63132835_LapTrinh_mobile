package com.tramquangvinh.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnmain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        btnmain = findViewById(R.id.btnMain);
        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gọi qua màng hình tạo 1 intent
                Intent myintent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(myintent);// muốn nó qua thì phải có dòng này

            }
        });
    }
}