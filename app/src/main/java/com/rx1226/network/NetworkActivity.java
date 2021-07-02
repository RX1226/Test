package com.rx1226.network;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.test.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetworkActivity extends AppCompatActivity {
    private final static String TAG = "NetworkActivity";
//    private String testUrl = "https://speed.cloudflare.com/"; // 國外
//    private String testUrl = "http://speedtest.googlefiber.net/"; //Google 國外 要點按鈕
//    private String testUrl = "https://tw.piliapp.com/speed-test/"; //工具邦, 要點按鈕
//    private String testUrl = "https://speedof.me/"; //speedof.me, 要點按鈕 國外 要同意cookie
//    private String testUrl = "https://www.bandwidthplace.com/"; //bandwidthplace, 要點按鈕 國外
//    private String testUrl = "http://speed.anet.net.tw/result.php"; //台灣大寬頻, 要點按鈕
//    private String testUrl = "https://doc.tstartel.com/sp/"; //台灣之星, 要點按鈕
//    private String testUrl = "http://speed5.ntu.edu.tw/speed5/";  //台大, 要點按鈕
    private String testUrl = "http://speed.ntu.edu.tw/index_noflash.php";  //台大
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        WebView web_view = findViewById(R.id.web_view);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setWebViewClient(new SpeedClient());
        web_view.loadUrl(testUrl);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Document document = Jsoup.connect(testUrl).get();
//                    Log.d("TAG", document.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    InetAddress address = InetAddress.getLocalHost();
//                    System.out.println(address);
//                    System.out.printf("HostName: %s%n", address.getHostName());
//                    System.out.printf("HostAddress: %s%n", address.getHostAddress());
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }

    private class SpeedClient extends WebViewClient{
        @Override
        public void onPageFinished(final WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("TAG", "onPageFinished url = " + url);

            Log.d("TAG", view.getContext().toString());
        }
    }
}