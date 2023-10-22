package com.tramquangvinh.argry_bird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class Image_activity extends AppCompatActivity {
    TableLayout mytable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        // anh xa
        mytable = findViewById(R.id.tablelayoutimage);
         int soDong = 6;
         int soCot =3;
         // tao dong va cot
        // tron mang
        Collections.shuffle(MainActivity.arrayname);
        for(int i=1 ; i<= soDong ; i++)
        {
            TableRow tableRow = new TableRow(this);
            // tao cột hay imageview
            for (int j = 1 ; j<= soCot ; j++){
                int vitri = soCot * (i-1) + j-1; // sáo trộn ảnh trong list
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(150,150);
                imageView.setLayoutParams(layoutParams);// hinh to qua gan vo cho no nho
                int idhinh = getResources().getIdentifier(MainActivity.arrayname.get(vitri),"drawable",getPackageName());
                imageView.setImageResource(idhinh);
                //add image view vào table row
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("Tenhinhchon",MainActivity.arrayname.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                        //Toast.makeText(Image_activity.this,MainActivity.arrayname.get(vitri), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            // add tablerow vào table
            mytable.addView(tableRow);
        }
    }
}