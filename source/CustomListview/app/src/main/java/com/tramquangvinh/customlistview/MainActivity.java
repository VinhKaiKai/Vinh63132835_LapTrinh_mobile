package com.tramquangvinh.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int image[] ={R.drawable.baobao,R.drawable.kai1,R.drawable.liu2,R.drawable.liu3,R.drawable.liu5,R.drawable.liu8,R.drawable.liu4,R.drawable.liu1};
    String name[] ={"BaoBao (宝宝)", "KaiKai 开开", "zhangLiu1 张柳", "zhangliu2", "zhangliu3", "zhangliu4", "zhangliu5", "zhangliu6"};
    // Khai báo list view
    ArrayList<Bear> mylist; // 1 Arraylist có kiểu dữ liệu là Bear
    MyarrayAdapter myadapter; // tạo 1 Arraydapter
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();// tạo mới môt mảng rỗng
        // để ép 2 mảng phía trên vào mảng rổng này
        for ( int i=0 ; i<name.length; i++)
        {
            mylist.add(new Bear(image[i],name[i]));
        }
        // Tạo mới adapter
        myadapter = new MyarrayAdapter(MainActivity.this,R.layout.layout_item, mylist ); // tham so 2 la cai layout nay tao
        // xu ly click



    }
}