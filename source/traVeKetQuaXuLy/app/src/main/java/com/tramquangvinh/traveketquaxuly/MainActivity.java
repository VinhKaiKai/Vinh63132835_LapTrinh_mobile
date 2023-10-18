package com.tramquangvinh.traveketquaxuly;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtdl , edtkq;
    Button btnxl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtdl = findViewById(R.id.edtdl);
        edtkq = findViewById(R.id.edtkq);
        btnxl = findViewById(R.id.btnxl);
        //Xử lý click
        btnxl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this , ResultActivity.class);
                int a = Integer.parseInt(edtdl.getText().toString());
                // Đưa dữ liệu về Intent
                myintent.putExtra("soa",a);
                startActivityForResult(myintent, 99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33){
            int kq = data.getIntExtra("kq",0);
            edtkq.setText("giá trị gốc là: "+kq);
        }else if(requestCode == 99 && resultCode ==34)
        {
            int kq = data.getIntExtra("kq",0);
            edtkq.setText("gía trị bình phương: "+kq);
        }
    }
}