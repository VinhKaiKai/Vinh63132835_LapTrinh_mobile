package com.tramquangvinh.hocsqlite_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến giao diện
    EditText edtmalop, edttenlop, edtsiso;
    Button btninsert, btndelete, btnupdate, btnload;
    //Khai báo list view
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tham chiếu
        edtmalop = findViewById(R.id.edtmalop);
        edttenlop = findViewById(R.id.edttenlop);
        edtsiso = findViewById(R.id.edtsiso);
        btninsert = findViewById(R.id.btnthem);
        btndelete = findViewById(R.id.btnxoa);
        btnupdate = findViewById(R.id.btncapnhat);
        btnload = findViewById(R.id.btnload);

        lv = findViewById(R.id.elv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mylist);
        lv.setAdapter(myadapter);
        //Tạo và mở cơ sở dữ liệu Sqlite
        mydatabase = openOrCreateDatabase("qlSinhVien.db",MODE_PRIVATE,null);
        //Tạo table để chứa dữ liệu
        try {
            String sql = "CREATE TABLE tbllop(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
            mydatabase.execSQL(sql);
        }
        catch (Exception e)
        {
            Log.e("Error!!!!!!!!"," Tồn tại rồi!!!");
        }

        ///Viết chức năng THÊM
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtmalop.getText().toString();
                String tenlop = edttenlop.getText().toString();
                int siso = Integer.parseInt(edtsiso.getText().toString());
                //Tạo bản ghi cho các dữ liệu trong table
                ContentValues myvalue = new ContentValues();
                myvalue.put("malop",malop);
                myvalue.put("tenlop",tenlop);
                myvalue.put("siso",siso);
                String msg = "";
                if(mydatabase.insert("tbllop",null, myvalue) == -1)
                {
                    msg="Lỗi khi thêm";
                }
                else{
                    msg="Thêm thành công!!!!";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //người dùng nhập vào mã lớp nào thì xóa mã lớp đó
                String malop111 = edtmalop.getText().toString();
                int n = mydatabase.delete("tbllop","malop = ?", new  String[]{malop111});
                //Dòng int ở trên là xóa cái dòng mà trong bảng tblop có điều kiện malop = String lấy từ cái malop ở trên kia
                String msg ="";
                if(n==0){
                    msg="Không có bản ghi nào được delete ";
                }
                else{
                    msg = "Có bản ghi được xóa";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        //Up date trường dữ liệu sỉ số
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int siso = Integer.parseInt(edtsiso.getText().toString());
                String malop = edtmalop.getText().toString();
                ContentValues myvalue = new ContentValues();
                myvalue.put("siso",siso);
                int n = mydatabase.update("tbllop",myvalue,"malop = ?", new String[]{malop});
                String msg="";
                if(n==0){
                    msg="Không được cập nhật thành công";
                }
                else{
                    msg = "có bản ghi được cập nhật";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist.clear(); // Xóa hết bản và truy vấn lại bảng
                Cursor c = mydatabase.query("tbllop",null,null,null,null, null, null);
                // đọc dữ liệu đọc từ bản ghi đầu tiên
                c.moveToNext();
                String data ="";
                while (c.isAfterLast() == false)
                {
                    data = c.getString(0) + " - " + c.getString(1) + " - " + c.getString(2);
                    c.moveToNext();
                    mylist.add(data);
                }
                c.close();
                myadapter.notifyDataSetChanged();
            }
        });

    }
}