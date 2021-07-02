package com.rx1226.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.test.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class YoutubeActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String YT_ID = "U1-djMsmHlM";
    private final String YT_API_KEY = "AIzaSyBhuET_T_wYLhew2U-yhz2YiDSlepgyUw0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_yt_web_view, YouTubeWebViewFragment.newInstance(YT_ID))
                .replace(R.id.fl_yt_api_web_view, YouTubeAPIWebViewFragment.newInstance(YT_ID))
                .commit();

        YouTubePlayerFragment youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager()
                .findFragmentById(R.id.fl_yt_api_view);

        youTubePlayerFragment.initialize(YT_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                Toast.makeText(YoutubeActivity.this, "onInitializationSuccess!", Toast.LENGTH_SHORT).show();
                if (youTubePlayer == null) {
                    Log.d("CheckPoint", "CheckPoint youtubePlayer == null");
                    return;
                }
                if (!wasRestored) {
                    Log.d("CheckPoint", "CheckPoint !wasRestored");
                    youTubePlayer.cueVideo(YT_ID);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(YoutubeActivity.this, "Failed to initialize.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_embed_web:

                break;
            case R.id.btn_youtube_api:

                break;
            case R.id.btn_youtube_embed:

                break;
        }
    }

    private void searchOnYoutube(final String keywords){
        new Thread(){
            public void run() {

            }
        }.start();
    }
}
