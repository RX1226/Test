package com.rx1226.youtube;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.R;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class YouTubeAPIWebViewFragment extends Fragment {
    private static final String TAG = "YouTubeAPIWebViewFragment";
    private static final String YOUTUBE_ID = "YOUTUBE_ID";
    private String youtubeId;

    public static YouTubeAPIWebViewFragment newInstance(String id) {
        YouTubeAPIWebViewFragment fragment = new YouTubeAPIWebViewFragment();
        Bundle args = new Bundle();
        args.putString(YOUTUBE_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            youtubeId = getArguments().getString(YOUTUBE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_youtube_api_web_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view);
//        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                youTubePlayer.loadVideo(youtubeId, 0);
//            }
//        });
    }
}
