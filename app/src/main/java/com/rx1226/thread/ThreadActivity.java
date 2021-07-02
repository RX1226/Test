package com.rx1226.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadActivity extends AppCompatActivity implements View.OnClickListener {
    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutorService;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        executorService = Executors.newFixedThreadPool(4);
//        executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        scheduledExecutorService = Executors.newScheduledThreadPool(5);
        try {
//            for (int i = 0; i < 5; i++) {
//                Thread.sleep(1000);
//                executorService.execute(new ThreadExample());
//            }
            // 循环任务，按照上一次任务的发起时间计算下一次任务的开始时间
//            scheduledExecutorService.scheduleAtFixedRate(new ThreadExample(),  1, 2, TimeUnit.SECONDS);
            // 循环任务，以上一次任务的结束时间计算下一次任务的开始时间
//            scheduledExecutorService.scheduleWithFixedDelay(new ThreadExample(),  1, 2, TimeUnit.SECONDS);
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    scheduledExecutorService.shutdown();
//                }
//            }, 10000);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
        finally {
//            executorService.shutdown();
//            scheduledExecutorService.shutdown(); //這邊不能關才會有循環效果
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
//                scheduledExecutorService.scheduleAtFixedRate(new ThreadExample(i++),  1, 2000, TimeUnit.MILLISECONDS);
                executorService.execute(new ThreadExample(i++));
                break;
            case R.id.btn_stop:
                Log.d("TAG", "shutdown()");
                if(scheduledExecutorService != null) scheduledExecutorService.shutdown();
                if(executorService != null) executorService.shutdown();
                break;
        }
    }

    public class ThreadExample implements Runnable {
        int index;
        ThreadExample(int i){
            index = i;
        }
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("run " + threadName + " thread " + index + " at " +System.currentTimeMillis());
                }
            });
        }
    }
}