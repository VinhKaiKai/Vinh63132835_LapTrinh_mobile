package com.tramquangvinh.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import de.hdodenhof.circleimageview.CircleImageView;

public class ManNhacNen extends AppCompatActivity {

    ImageButton btnback, btnplay, btnstop;
    CircleImageView mCircleImageView;
    Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_nhac_nen);
        //Anh xa

        btnplay = findViewById(R.id.btnplay);
        btnstop = findViewById(R.id.btnstop);
        mCircleImageView = findViewById(R.id.img_avt);
        btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // xét sự kiện cho nút play
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khai bao intent cong khai de khoi dong service
                Intent intent1 = new Intent(ManNhacNen.this, MyService.class);
                startService(intent1);//chạy
                // Thay đổi ảnh
                if(flag == true){
                    btnplay.setImageResource(R.drawable.pause2);
                    startAnimation();// chạy nhạc là true hết. khi mà true mà đc nhấn vô thì dừng nhạc và nó thành flase
                    flag = false;
                }
                else {
                    btnplay.setImageResource(R.drawable.play2);// nhạc dừng mà đc nhấn vô nó sẽ đổi ảnh mà biến thành true
                    flag = true;
                    stopAnimation();
                }
            }
        });
        // xét sự kiện cho nút stop
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khai bao intent cong khai de khoi dong service
                Intent intent2 = new Intent(ManNhacNen.this, MyService.class);
                stopService(intent2);//Đóng
                btnplay.setImageResource(R.drawable.play2);
                khongquay();// nhạc dừng mà đc nhấn vô nó sẽ đổi ảnh mà biến thành true
                flag = true;
            }
        });
    }
    private float initialRotation = 0f;
    private void  khongquay()
    {
        mCircleImageView.animate().cancel();
        mCircleImageView.setRotation(initialRotation);
    }
    private void  startAnimation()
    {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mCircleImageView.animate().rotationBy(360).withEndAction(this).setDuration(10000)
                        .setInterpolator(new LinearInterpolator()).start();
            }
        };
        mCircleImageView.animate().rotationBy(360).withEndAction(runnable).setDuration(10000)
                .setInterpolator(new LinearInterpolator()).start();
    }
    private void  stopAnimation()
    {
        mCircleImageView.animate().cancel();
    }
}