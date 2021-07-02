package com.rx1226.webview;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class InJavaScriptLocalObj {
    private WebView webView;

    public InJavaScriptLocalObj(WebView webView) {
        this.webView = webView;
    }

    @JavascriptInterface
    public void showSource(String html) {
        System.out.println("===html===\n" + html);
//        webView.loadDataWithBaseURL(null, body, "text/html", "utf-8", null);
    }

    @JavascriptInterface
    public void showDescription(String str) {
        System.out.println("===html string===\n" + str);
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
}
