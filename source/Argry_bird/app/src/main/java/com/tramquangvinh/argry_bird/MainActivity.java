package com.tramquangvinh.argry_bird;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arrayname;
    ImageView imggoc, imgnhan;
    int REQUEST_CODE_IMAGE = 123;
    String tenhinhgoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imggoc = findViewById(R.id.imggoc);
        imgnhan = findViewById(R.id.imgnhan);

        String[] mangten = getResources().getStringArray(R.array.list_name);// chu thuong
        arrayname = new ArrayList<>(Arrays.asList(mangten));
        // gan giao dien

        /// sáo trộn phần tử trong mảng
        Collections.shuffle(arrayname); // trộn xong
        tenhinhgoc = arrayname.get(5);

        int idhinh = getResources().getIdentifier(arrayname.get(5),"drawable",getPackageName()); // dặt id cho tấm hình 6 do index

        imggoc.setImageResource(idhinh);

        //click
        imgnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyển màng hình thứ 2 khi ấn vào
                startActivityForResult(new Intent(MainActivity.this, Image_activity.class), REQUEST_CODE_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_IMAGE && resultCode == REQUEST_CODE_IMAGE && data != null)
        {
            String tenhinhnhan = data.getStringExtra("tenhinhchon");
            int ihinhchon = getResources().getIdentifier(tenhinhnhan,"drawble",getPackageName());
            imgnhan.setImageResource(ihinhchon);
            // so sanh
            if(tenhinhgoc.equals(tenhinhnhan)){
                Toast.makeText(this, "Chính xác", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Sai rồi", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}