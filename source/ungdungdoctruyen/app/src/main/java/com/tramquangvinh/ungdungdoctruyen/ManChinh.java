package com.tramquangvinh.ungdungdoctruyen;

import com.tramquangvinh.ungdungdoctruyen.adapter.adapterchuyenmuc;
import com.tramquangvinh.ungdungdoctruyen.adapter.adapterthongtin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.bdtopcoder.smart_slider.SliderAdapter;
import com.bdtopcoder.smart_slider.SliderItem;
import com.google.android.material.navigation.NavigationView;
import com.tramquangvinh.ungdungdoctruyen.adapter.adapterTruyen;
import com.tramquangvinh.ungdungdoctruyen.model.TaiKhoan;
import com.tramquangvinh.ungdungdoctruyen.model.Truyen;
import com.tramquangvinh.ungdungdoctruyen.database.Databasedoctruyen;
import com.tramquangvinh.ungdungdoctruyen.model.chuyenmuc;

import java.util.ArrayList;
import java.util.List;

public class ManChinh extends AppCompatActivity {


    Toolbar toolbar;
    Databasedoctruyen databasedoctruyen;
    NavigationView navigationView;
    ListView listView, listViewNew, listViewThongTin;
    DrawerLayout drawerLayout;
    String email;
    String tentaikhoan;
    ArrayList<chuyenmuc> chuyenmucArrayList;
    ArrayList<TaiKhoan> taiKhoanArrayList;
    ArrayList<Truyen> TruyenArraylist;
    adapterTruyen adapterTruyen;
    adapterthongtin adapterthongtin;
    adapterchuyenmuc adapterchuyenmuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_chinh);
        databasedoctruyen = new Databasedoctruyen(this);

        // nhan data tu dang nhap
        Intent intentpq = getIntent();
        int phanquyen = intentpq.getIntExtra("phanq",0);
        int idd = intentpq.getIntExtra("idd",0);
        email = intentpq.getStringExtra("email");
        tentaikhoan = intentpq.getStringExtra("tentaikhoan");


        Anhxa();
        ActionBar();
        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(ManChinh.this,ManNoiDung.class);
                String tent = TruyenArraylist.get(position).getTenTruyen();
                String noidungt = TruyenArraylist.get(position).getNoiDung();
                myintent.putExtra("tentruyen",tent);
                myintent.putExtra("noidung",noidungt);
                startActivity(myintent);
            }
        });
        // bắt sự kiện listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Log.e("Đăng bài:", "Bạn không có quyền");
                    if(phanquyen == 2)
                    {
                        Intent intent = new Intent(ManChinh.this, ManAdmin.class);
                        //gui id tai khoan qua man admin
                        intent.putExtra("Id",idd);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ManChinh.this, "Bạn không có quyền Đăng bài!", Toast.LENGTH_SHORT).show();
                        Log.e("Đăng bài:", "Bạn không có quyền");
                    }
                }
                else if (position ==1)
                {
                    Intent intent = new Intent(ManChinh.this, ManThongTin.class);
                    startActivity(intent);

                } else if (position ==2) {
                    finish();
                }
            }
        });










        ViewPager2 viewPager2 = findViewById(R.id.smartSlider);
        // làm chuyển ảnh tự động
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.truyen1,"image 1"));
        sliderItems.add(new SliderItem(R.drawable.truyen2,"Image 2"));
        sliderItems.add(new SliderItem(R.drawable.truyen3,"Image 3"));
        sliderItems.add(new SliderItem(R.drawable.truyen4,"Image 3"));
        sliderItems.add(new SliderItem(R.drawable.truyen5,"Image 3"));
        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2,3000));
        new SliderAdapter((position, title, view) -> {
            Toast.makeText(this, "Position: "+position+" Title: "+title, Toast.LENGTH_SHORT).show();
        });
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        // Set nút cho actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // tạo icon cho toolbar
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {

        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        listViewNew = findViewById(R.id.listviewNew);
        listView = findViewById(R.id.listviewmanhinhchinh);
        listViewThongTin = findViewById(R.id.listviewthongtin);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerlayout);
        TruyenArraylist = new ArrayList<>();
        Cursor cursor1 = databasedoctruyen.getData1();
        while (cursor1.moveToNext())
        {
            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);
            TruyenArraylist.add(new Truyen(id,tentruyen,noidung,anh,id_tk));
            adapterTruyen = new adapterTruyen(getApplicationContext(),TruyenArraylist);
            listViewNew.setAdapter(adapterTruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();
        //Thông tin
         taiKhoanArrayList = new ArrayList<>();
         taiKhoanArrayList.add(new TaiKhoan(tentaikhoan,email));

        adapterthongtin = new adapterthongtin(this,R.layout.navigation_thongtin,taiKhoanArrayList);
        listViewThongTin.setAdapter(adapterthongtin);

        // chuyen muc
        chuyenmucArrayList = new ArrayList<>();
        chuyenmucArrayList.add(new chuyenmuc("Đăng bài", R.drawable.ic_post));
        chuyenmucArrayList.add(new chuyenmuc("Thông tin",R.drawable.face));
        chuyenmucArrayList.add(new chuyenmuc("Đăng xuất", R.drawable.logout));
        adapterchuyenmuc = new adapterchuyenmuc(this, R.layout.chuyenmuc,chuyenmucArrayList);
        listView.setAdapter(adapterchuyenmuc);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu1) {
            // Xử lý sự kiện khi menu1 được chọn
            Intent myintent = new Intent(ManChinh.this, ManTimKiem.class);
            startActivity(myintent);

        }
        return super.onOptionsItemSelected(item);
    }
}