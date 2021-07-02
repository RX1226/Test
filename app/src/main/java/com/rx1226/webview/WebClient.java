package com.rx1226.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebClient extends WebViewClient {
    private boolean isFinish;
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if(isFinish) return;
        else view.setVisibility(View.INVISIBLE);
        super.onPageStarted(view, url, favicon);
        Log.d("TAG", "onPageStarted url = " + url);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        Log.d("TAG", "onReceivedError = " + error.toString());
    }



    @Override
    public void onPageFinished(final WebView view, String url) {
        if(isFinish) return;
        super.onPageFinished(view, url);
        // 在结束加载网页时会回调
        // 获取页面内容
        Log.d("TAG", "onPageFinished url = " + url);
//        view.loadUrl("javascript:window.java_obj.showSource("
//                + "document.getElementsByTagName('html')[0].innerHTML);");

        view.loadUrl("javascript:window.java_obj.showSource('<head>'+"
                + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.loadDataWithBaseURL(null, body, "text/html", "utf-8", null);
                view.setVisibility(View.VISIBLE);
                isFinish = true;
            }
        }, 100);
//        view.loadDataWithBaseURL(null, body, "text/html", "utf-8", null);
//        // 获取解析<meta name="share-description" content="获取到的值">
//        view.loadUrl("javascript:window.java_obj.showDescription("
//                + "document.querySelector('meta[name=\"share-description\"]').getAttribute('content')"
//                + ");");

    }

    private String body = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<title>Page Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "<h1>This is a Heading</h1>\n" +
            "<p>This is a paragraph.</p>\n" +
            "\n" +
            "</body>\n" +
            "</html>\n";

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.d("TAG", "shouldOverrideUrlLoading url = " + url);
        isFinish = false;
        view.loadUrl(url);
        return true;
    }

//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//        Log.d("TAG", "url = " + request.getUrl().getPath());
//        return super.shouldOverrideUrlLoading(view, request);
//    }
}
