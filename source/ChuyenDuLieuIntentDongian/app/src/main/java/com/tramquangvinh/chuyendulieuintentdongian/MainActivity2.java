package com.tramquangvinh.chuyendulieuintentdongian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView txtkq, txtkq2 , txtkq3 , txtkq4, txtbundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtkq = findViewById(R.id.edtdulieu);
        txtkq2 = findViewById(R.id.edtdulieuint);
        txtkq3 = findViewById(R.id.edtdulieumang);
        txtkq4 = findViewById(R.id.edtdulieudoituong);
        txtbundle = findViewById(R.id.txtbundle);
        // nhân dự liệu từ intent từ bên main chính
        Intent vinh = getIntent();
        String chuoi = "";
        chuoi = vinh.getStringExtra("dulieu");
        // Kiểm tra lấy đc hay ko thì hiển thị lên text view
        txtkq.setText(chuoi);

        // nhận kiểu số
        Intent lap = getIntent();
        int so = lap.getIntExtra("dulieu2",5092003); //tham số 1 nó phân biệt chữ hoa chữ thường. tham số thứ 2 là khi số ko truyền đc nó sẽ gán cho số 5092003
        txtkq2.setText(so+"");

        // nhận dữ liệu kiểu mảng
        Intent Huy = getIntent();
        String chuoitonghop ="";
        String[] mang = Huy.getStringArrayExtra("dulieu3");
        for(int i=0 ; i<mang.length ;i++)
        {
            chuoitonghop = chuoitonghop + mang[i] +" ";
        }
        txtkq3.setText(chuoitonghop);

        // nhận dữ liệu kiểu đối tượng
        Intent quan = getIntent();
        SinhVien hs = (SinhVien) quan.getSerializableExtra("dulieu4");
        txtkq4.setText("Tên là: "+ hs.getName()+"\n" +"Tuổi là: " + hs.getTuoi()+"\n " + "Địa chỉ là: "+ " " + hs.getDiachi()+"\n " +"");


        // Nhận dữ liệu của bundle gửi qua
        Intent tri = getIntent();
        Bundle dulieucuabundledayne = tri.getBundleExtra("dulieucuabundle");
        if(dulieucuabundledayne !=null)
        {
            // bây giờ tui sẽ lấy chuổi ra
            String ten = dulieucuabundledayne.getString("chuoi");
            // bây giờ tui sẽ lấy int ra
            int number = dulieucuabundledayne.getInt("conso",123);
            // bây giờ tui sẽ lấy mảng ra
            String[] chuoimang = dulieucuabundledayne.getStringArray("arrayne");
            // bây giờ tui sẽ lấy Đối tượng
            SinhVien sv = (SinhVien) dulieucuabundledayne.getSerializable("hocsinhne");

            txtbundle.setText("Tên là: "+ ten +"\n"+
                              "Con số :"+ number +"\n"+
                              "Lấy mảng:" + chuoimang[2]+"\n"+
                               "Sinh viên: "+ sv.getName());
        }
        else
        {
            Toast.makeText(this, "ko has data", Toast.LENGTH_SHORT).show();
        }
    }
}