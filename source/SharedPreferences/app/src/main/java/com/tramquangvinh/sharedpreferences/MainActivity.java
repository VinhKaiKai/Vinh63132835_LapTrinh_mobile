package com.tramquangvinh.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb, edtkq;
    Button btntong, btnclear;
    TextView txt_lichsu;
    String lichsu="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtkq = findViewById(R.id.edtkq);
        txt_lichsu = findViewById(R.id.txtlichsu);
        btntong = findViewById(R.id.btntong);
        btnclear = findViewById(R.id.btnxoa);

        // đọc lại dữ liệu đã lưu
        SharedPreferences mypref = getSharedPreferences("mysave", MODE_PRIVATE);
        lichsu =mypref.getString("ls","");
        txt_lichsu.setText(lichsu);
        // xử lý click
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int k = a+b;
                edtkq.setText(k+"");
                lichsu+=a + "+" + b + " = " +k;
                txt_lichsu.setText(lichsu);
                lichsu+="\n";
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lichsu = "";
                txt_lichsu.setText(lichsu);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //4 step lưu trữ dữ liệu
        SharedPreferences mypref = getSharedPreferences("mysave", MODE_PRIVATE);
        SharedPreferences.Editor myedit = mypref.edit();
        myedit.putString("ls",lichsu);
        myedit.commit();
    }
}