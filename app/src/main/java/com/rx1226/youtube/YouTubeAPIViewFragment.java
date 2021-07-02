package com.rx1226.youtube;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeAPIViewFragment extends YouTubePlayerFragment {
    private static final String TAG = "YouTubeAPIViewFragment";
    private static final String YOUTUBE_ID = "YOUTUBE_ID";
    private String youtubeId;
    private final String YT_API_KEY = "AIzaSyBhuET_T_wYLhew2U-yhz2YiDSlepgyUw0";

    public static YouTubeAPIViewFragment newInstance(String id) {
        YouTubeAPIViewFragment fragment = new YouTubeAPIViewFragment();
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
        return inflater.inflate(R.layout.fragment_youtube_api_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(YT_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                if (youTubePlayer == null) {
                    Log.d("CheckPoint", "CheckPoint youtubePlayer == null");
                    return;
                }
                if (!wasRestored) {
                    Log.d("CheckPoint", "CheckPoint !wasRestored");
                    youTubePlayer.cueVideo(youtubeId);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getActivity(), "Failed to initialize.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
