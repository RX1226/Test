package com.rx1226.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.test.R;


public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        WebView web_view = findViewById(R.id.web_view);
        // 开启JavaScript支持
        web_view.getSettings().setJavaScriptEnabled(true);

        web_view.addJavascriptInterface(new InJavaScriptLocalObj(web_view), "java_obj");

//        // 设置WebView是否支持使用屏幕控件或手势进行缩放，默认是true，支持缩放
//        web_view.getSettings().setSupportZoom(true);
//
//        // 设置WebView是否使用其内置的变焦机制，该机制集合屏幕缩放控件使用，默认是false，不使用内置变焦机制。
//        web_view.getSettings().setBuiltInZoomControls(true);
//
//        // 设置是否开启DOM存储API权限，默认false，未开启，设置为true，WebView能够使用DOM storage API
//        web_view.getSettings().setDomStorageEnabled(true);
//
//        // 触摸焦点起作用.如果不设置，则在点击网页文本输入框时，不能弹出软键盘及不响应其他的一些事件。
//        web_view.requestFocus();
//
//        // 设置此属性,可任意比例缩放,设置webview推荐使用的窗口
//        web_view.getSettings().setUseWideViewPort(true);
//
//        // 设置webview加载的页面的模式,缩放至屏幕的大小
//        web_view.getSettings().setLoadWithOverviewMode(true);

        web_view.setWebViewClient(new WebClient());
        web_view.loadUrl("http://www.99kubo.tv/");
//        web_view.loadUrl("http://www.chwa.com.tw/TResource/HS/book2/ch8/ch8-5.19.gif");
    }
}
