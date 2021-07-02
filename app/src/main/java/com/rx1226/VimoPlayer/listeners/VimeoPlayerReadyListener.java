package com.rx1226.VimoPlayer.listeners;


import com.rx1226.VimoPlayer.model.TextTrack;

public interface VimeoPlayerReadyListener {
    void onReady(String title, float duration, TextTrack[] textTrackArray);

    void onInitFailed();
}
