package com.tramquangvinh.listview_coban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String myphone[] = {"SamSung s23ultra", "SamSung s22ultra","SamSung s21ultra","SamSung s20ultra"};
    ArrayAdapter<String> myadapter;
    ListView lv1;
    TextView txt_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Anh xa
        txt_select = findViewById(R.id.txt_select);
        lv1 = findViewById(R.id.lv1);

        //set up adapter
        myadapter = new ArrayAdapter<>(MainActivity.this,     android.R.layout.simple_list_item_1,   myphone);
        lv1.setAdapter(myadapter);
        // Bắt sự kiện click vào Item ss
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt_select.setText("Index : " + i +" " +myphone[i]);
            }
        });
    }


}