package com.tramquangvinh.nghenhac;

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
        mymusic = MediaPlayer.create(MyService.this,R.raw.tutanhoan);
        mymusic.setLooping(true);// hat di hat lai bai hat
    }
    // ham dung de chạy doi tuong service quan ly
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(mymusic.isPlaying())
        {
            mymusic.pause();
        }
        else
        {
            mymusic.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }
    // ham de dừng doi tuong ma service quan ly

    @Override
    public void onDestroy() {
        super.onDestroy();
        mymusic.stop();
    }
}