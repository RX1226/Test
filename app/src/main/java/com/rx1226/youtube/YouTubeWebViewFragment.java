package com.rx1226.youtube;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.test.R;

public class YouTubeWebViewFragment extends Fragment {
    private static final String TAG = "YouTubeWebViewFragment";
    private static final String YOUTUBE_ID = "YOUTUBE_ID";
    private final String YT_EMD_URL = "https://www.youtube.com/embed/";
    private String youtubeId;

    public static YouTubeWebViewFragment newInstance(String id) {
        YouTubeWebViewFragment fragment = new YouTubeWebViewFragment();
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
        return inflater.inflate(R.layout.fragment_youtube_web_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView web_view = view.findViewById(R.id.web_view);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        web_view.loadUrl(YT_EMD_URL + youtubeId);
    }
}
