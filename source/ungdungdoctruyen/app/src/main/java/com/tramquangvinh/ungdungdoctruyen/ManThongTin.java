package com.tramquangvinh.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ManThongTin extends AppCompatActivity {

    TextView linkTextView, taiday2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_thong_tin);

        linkTextView = findViewById(R.id.textView19);
        taiday2 = findViewById(R.id.textView20);
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook();
            }
        });
        taiday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGithub();
            }
        });

        }
    public void openFacebook() {
        String facebookUrl = "https://www.facebook.com/quangvinh.tram.5";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(facebookUrl));
        startActivity(intent);
    }
    public void openGithub() {
        String githublink = "https://github.com/VinhKaiKai/Vinh63132835_LapTrinh_mobile/tree/main/source/ungdungdoctruyen";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(githublink));
        startActivity(intent);
    }
}