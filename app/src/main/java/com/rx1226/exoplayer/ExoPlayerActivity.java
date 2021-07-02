package com.rx1226.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.test.R;
//import com.google.android.exoplayer2.ExoPlayer;
//import com.google.android.exoplayer2.ExoPlayerFactory;
//import com.google.android.exoplayer2.MediaItem;
//import com.google.android.exoplayer2.SimpleExoPlayer;
//import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
//import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
//import com.google.android.exoplayer2.trackselection.TrackSelection;
//import com.google.android.exoplayer2.trackselection.TrackSelector;
//import com.google.android.exoplayer2.ui.PlayerView;
//import com.google.android.exoplayer2.upstream.BandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;

public class ExoPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player);


//        DefaultTrackSelector trackSelector = new DefaultTrackSelector(this);
//        SimpleExoPlayer player = new SimpleExoPlayer.Builder(this)
//                .setTrackSelector(trackSelector)
//                .build();
//        PlayerView exoplayer_view = findViewById(R.id.exoplayer_view);
//        exoplayer_view.setPlayer(player);
//        MediaItem mediaItem = MediaItem.fromUri("https://chopin.ccu.edu.tw/Site/w8310378-gmail_com/dir_5161a93245964/.nuweb_media/file_51927641a608c.mp4.mp4");
//        player.setMediaItem(mediaItem);
//        player.prepare();
//        player.play();
    }
}