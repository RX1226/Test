package com.rx1226.VimoPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test.R;
import com.rx1226.VimoPlayer.model.VimeoOptions;
import com.rx1226.VimoPlayer.utils.JsBridge;

public class VimoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vimo);

        VimeoPlayer vimeoPlayer = findViewById(R.id.player);
        VimeoOptions vimeoOptions = new VimeoOptions();
        vimeoOptions.originalControls = false;
        vimeoOptions.muted = false;
        vimeoOptions.autoPlay = true;
        vimeoPlayer.initialize(false, new JsBridge(), vimeoOptions, 452237068, "", "https://vimeo.com/");
        vimeoPlayer.play();
    }
}