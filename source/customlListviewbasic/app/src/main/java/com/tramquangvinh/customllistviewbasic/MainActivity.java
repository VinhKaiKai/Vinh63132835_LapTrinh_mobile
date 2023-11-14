package com.tramquangvinh.customllistviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.tramquangvinh.customlListviewbasic.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Tạo mảng dữ liệu
    int image[]={R.drawable.liu1, R.drawable.liu2, R.drawable.liu3, R.drawable.liu4 , R.drawable.liu5, R.drawable.liu6, R.drawable.liu7, R.drawable.liu8};
    String name[]={"liu 1","liu2", "liu3", "liu4", "liu5" ,  "liu6" , "liu7" , "liu8"  };
    ArrayList<Phone> mylist;
    MyArrayAdapter myadapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        for(int i =0; i< name.length ; i++)
        {
            mylist.add(new Phone(image[i], name[i]));
        }
        myadapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, mylist);
        lv.setAdapter(myadapter);
    }
}