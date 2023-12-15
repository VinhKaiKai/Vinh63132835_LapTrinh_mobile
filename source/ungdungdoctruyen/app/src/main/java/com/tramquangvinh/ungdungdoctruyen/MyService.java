package com.tramquangvinh.ungdungdoctruyen;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    // khai bao doi tuong quan ly bai nhac
    MediaPlayer mymusic;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    // ham oncreate  khoi tao doi tuong ma service quan ly
    @Override
    public void onCreate() {
        super.onCreate();
        mymusic = MediaPlayer.create(MyService.this,R.raw.khuvuontrenmay);
        mymusic.setLooping(true);// hat di hat lai bai hat
    }
    // ham dung de chạy doi tuong service quan ly
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(mymusic.isPlaying()) // đang phát thì tạm ngừng
        {
            mymusic.pause(); // Tạm ngừng
        }
        else
        {
            mymusic.start(); // còn nếu không đang phát thì dừng lại
        }
        return super.onStartCommand(intent, flags, startId);
    }

    // ham de dừng doi tuong ma service quan ly

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mymusic != null) {
            mymusic.release(); // giải phóng tài nguyên
        }
        //mymusic.stop(); // dừng nhạc luôn
    }
}