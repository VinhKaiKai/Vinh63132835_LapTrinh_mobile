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
        // Nhận data từ đăng nhập
        Intent intentpq = getIntent();
        int phanquyen = intentpq.getIntExtra("phanq",0);
        int idd = intentpq.getIntExtra("idd",0);
        email = intentpq.getStringExtra("email");
        tentaikhoan = intentpq.getStringExtra("tentaikhoan");
        Anhxa();
        ActionBar();

        // sử lý khi người dùng chọn vào danh sách truyện
        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // đẩy cái tên với cái nội dung qua màn nội dung để hiển thị
                Intent myintent = new Intent(ManChinh.this,ManNoiDung.class);
                String tent = TruyenArraylist.get(position).getTenTruyen();
                String noidungt = TruyenArraylist.get(position).getNoiDung();
                myintent.putExtra("tentruyen",tent);
                myintent.putExtra("noidung",noidungt);
                startActivity(myintent);
            }
        });

        // bắt sự kiện listview chức năng trên menu
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Log.e("Đăng bài:", "Bạn không có quyền");
                    if(phanquyen == 2)
                    {
                        Intent intent = new Intent(ManChinh.this, ManAdmin.class);
                        //gửi id tài khoản qua màn admin
                        intent.putExtra("Id",idd);
                        startActivity(intent);
                    }
                    else
                    {
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
                } else if (position ==3)
                {
                    Intent intent = new Intent(ManChinh.this, ManNhacNen.class);
                    startActivity(intent);
                }
            }
        });

        ViewPager2 viewPager2 = findViewById(R.id.smartSlider);
        // làm chuyển ảnh tự động
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.truyen1,"image 1"));
        sliderItems.add(new SliderItem(R.drawable.truyen2,"Image 2"));
        sliderItems.add(new SliderItem(R.drawable.truyen3,"Image 3"));
        sliderItems.add(new SliderItem(R.drawable.truyen4,"Image 4"));
        sliderItems.add(new SliderItem(R.drawable.truyen5,"Image 5"));
        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2,3000));
        new SliderAdapter((position, title, view) -> {
            Toast.makeText(this, "Position: "+position+" Title: "+title, Toast.LENGTH_SHORT).show();
        });
    }
    // hàm thiết lập nút 3 gạch để đống mở menu
    private void ActionBar()
    {
        setSupportActionBar(toolbar);
        // Set nút cho actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // tạo icon cho toolbar
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi nút back trên action bar được nhấn, mở drawer layout từ bên trái (GravityCompat.START).
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

        // Tạo 1 con trỏ
        Cursor cursor1 = databasedoctruyen.getData1();
        // để lấy 5 quyển truyện mới nhất từ data ra màn hình hiển thị
        while (cursor1.moveToNext())
        {
            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);
            // lấy rồi thêm vô cái list
            TruyenArraylist.add(new Truyen(id,tentruyen,noidung,anh,id_tk));
            // nhét vô cái adapter
            adapterTruyen = new adapterTruyen(getApplicationContext(),TruyenArraylist);
            // hiển thị truyện lên listview
            listViewNew.setAdapter(adapterTruyen);
        }
        // chạy xong cho nó lên dòng đầu (con trỏ)
        cursor1.moveToFirst();
        // đóng con trỏ
        cursor1.close();

        //thông tin khi nhấn vào cái menu khi nhận dữ liệu từ màn đăng nhập qua thì lấy nó bỏ vô list tài khoản
         taiKhoanArrayList = new ArrayList<>();
         taiKhoanArrayList.add(new TaiKhoan(tentaikhoan,email));
        // nhét vô layout navigation_thongtin
        adapterthongtin = new adapterthongtin(this,R.layout.navigation_thongtin,taiKhoanArrayList);
        listViewThongTin.setAdapter(adapterthongtin);

        // phần chuyên mục
        chuyenmucArrayList = new ArrayList<>();
        chuyenmucArrayList.add(new chuyenmuc("Đăng bài", R.drawable.ic_post));
        chuyenmucArrayList.add(new chuyenmuc("Thông tin",R.drawable.face));
        chuyenmucArrayList.add(new chuyenmuc("Đăng xuất", R.drawable.logout));
        chuyenmucArrayList.add(new chuyenmuc("Nhạc nền", R.drawable.logout));
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