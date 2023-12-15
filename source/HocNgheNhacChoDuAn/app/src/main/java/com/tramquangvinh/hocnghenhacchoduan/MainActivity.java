package com.tramquangvinh.hocnghenhacchoduan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CircleImageView mCircleImageView;
    Button btnbatdau, btndung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        mCircleImageView = findViewById(R.id.img_avt);
        btnbatdau = findViewById(R.id.btnplay);
        btndung = findViewById(R.id.btnstop);

        btnbatdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        btndung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimation();
            }
        });
    }
    private void  startAnimation()
    {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mCircleImageView.animate().rotation(360).withEndAction(this).setDuration(10000)
                        .setInterpolator(new LinearInterpolator()).start();
            }
        };
        mCircleImageView.animate().rotation(360).withEndAction(runnable).setDuration(10000)
                .setInterpolator(new LinearInterpolator()).start();
    }
    private void  stopAnimation()
    {
        mCircleImageView.animate().cancel();
    }
}