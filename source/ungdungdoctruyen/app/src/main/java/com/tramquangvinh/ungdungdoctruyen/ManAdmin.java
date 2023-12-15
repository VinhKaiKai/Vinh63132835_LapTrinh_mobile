package com.tramquangvinh.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import com.tramquangvinh.ungdungdoctruyen.adapter.adapterTruyen;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.tramquangvinh.ungdungdoctruyen.database.Databasedoctruyen;
import com.tramquangvinh.ungdungdoctruyen.model.Truyen;

import java.util.ArrayList;

public class ManAdmin extends AppCompatActivity {
    ListView listView;
    Button buttonThem;
    ArrayList<Truyen> TruyenArrayList;
    adapterTruyen adapterTruyen;
    Databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_admin);
        listView = findViewById(R.id.listviewAdmin);
        buttonThem = findViewById(R.id.buttonThemtruyen);

        initlist();
        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Lấy id tài khoản để biết tài khoản admin nào chinh suawr
                Intent intent1 = getIntent();
                int id = intent1.getIntExtra("Id",0);

                // tiếp tục gửi id qua manf hình thêm truyện
                Intent intent = new Intent(ManAdmin.this, ManDangBai.class);
                intent.putExtra("Id",id);
                startActivity(intent);

            }
        });

        // click dài sẽ xóa truyện
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DialogDelete(position);
                return false;
            }
        });
    }
    private void DialogDelete(int position){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogdelete);// nap layout vo
        dialog.setCanceledOnTouchOutside(false);
        // anh xa
        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idtruyen = TruyenArrayList.get(position).getID();
                databasedoctruyen.Delete(idtruyen);
                //tự động cập nhật lại
                Intent intent = new Intent(ManAdmin.this, ManAdmin.class);
                finish();
                startActivity(intent);
                Toast.makeText(ManAdmin.this, "Xóa truyện thành công!", Toast.LENGTH_SHORT).show();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();

    }
// gan du lieu cho listview
    private void initlist() {
        TruyenArrayList = new ArrayList<>();

        databasedoctruyen = new Databasedoctruyen(this);
        Cursor cursor1 = databasedoctruyen.getData2();

        while (cursor1.moveToNext())
        {
            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);
            TruyenArrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));

            adapterTruyen = new adapterTruyen(getApplicationContext(),TruyenArrayList);
            listView.setAdapter(adapterTruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();
    }
}