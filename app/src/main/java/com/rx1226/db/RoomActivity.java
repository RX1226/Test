package com.rx1226.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.test.R;
import com.rx1226.db.entity.UserEntity;

import java.util.List;

public class RoomActivity extends AppCompatActivity {
    private static final String TAG = "RoomActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        final AppDatabase database = AppDatabase.getInstance(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                UserEntity userEntity = (new UserEntity("Willw", 3));
                userEntity.setId(2);
                database.getUserDao().delete(userEntity);
                database.getUserDao().delete(new UserEntity("Willie2", 2));
                database.getUserDao().delete(new UserEntity("Willie3", 3));

                Log.d(TAG, database.getUserDao().queryByName("Willie1").getId() + database.getUserDao().queryByName("Willie1").getName());

                List<UserEntity> list = database.getUserDao().getAllUser();
                for (UserEntity entity : list) {
                    Log.d(TAG, entity.getId() + " " + entity.getName());
                }
            }
        }).start();
    }
}