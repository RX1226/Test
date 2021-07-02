package com.rx1226.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.test.R;

import java.util.Timer;
import java.util.TimerTask;

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "HandlerActivity";
    private Handler handler;
    private HandlerThread handlerThread;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        Log.d(TAG, "HandlerActivity onCreate()");
        handlerThread = new HandlerThread("Main Loop");
        handlerThread.start();

        handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Log.d(TAG, "msg = " + msg.what);
            }
        };
//        handlerThread.quit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handlerThread.quit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("vidol://episodes?id=36218"));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

//                timer = new Timer();
//                TimerTask task= new TimerTask() {
//                    int i = 0;
//                    @Override
//                    public void run() {
//                        handler.sendEmptyMessage(i++);
//                    }
//                };
//                timer.schedule(task, 0, 100);
                break;
            case R.id.stop:
                Log.d(TAG, "stop");
//                handlerThread.quit();
                timer.cancel();
                timer = null;
                break;
        }
    }
}