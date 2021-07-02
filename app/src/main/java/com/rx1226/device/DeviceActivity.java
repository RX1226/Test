package com.rx1226.device;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.example.test.R;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class DeviceActivity extends AppCompatActivity {
    private final String TAG = "DeviceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

//        Log.d(TAG, "boad = " + Build.BOARD);
//        Log.d(TAG, "brand = " + Build.BRAND);
//        Log.d(TAG, "cpu = " + Arrays.toString(Build.SUPPORTED_ABIS));
//        Log.d(TAG, "device = " + Build.DEVICE);
//        Log.d(TAG, "display = " + Build.DISPLAY);
////        Log.d(TAG, "fingerprint = " + Build.FINGERPRINT);
////        Log.d(TAG, "host = " + Build.HOST);
////        Log.d(TAG, "hardward = " + Build.HARDWARE);
////        Log.d(TAG, "id = " + Build.ID); //版本號
//        Log.d(TAG, "manufacturer = " + Build.MANUFACTURER);
//        Log.d(TAG, "model = " + Build.MODEL);
//        Log.d(TAG, "product = " + Build.PRODUCT);
//        Log.d(TAG, "tags = " + Build.TAGS);
//        Log.d(TAG, "type = " + Build.TYPE);
//        Log.d(TAG, "user = " + Build.USER);
//        Log.d(TAG, "VERSION = " + Build.VERSION.RELEASE);


//        String strBase64 = "qqq@gmail.com";
//        Log.d("Test", strBase64);
//
//        // 这里 encodeToString 则直接将返回String类型的加密数据
//        String enToStr = Base64.encodeToString(strBase64.getBytes(), Base64.DEFAULT);
//        Log.d("Test", "encodeToString >>> " + enToStr);
//
//
//        // 解密
//        String deStr = new String(Base64.decode(enToStr, Base64.DEFAULT));
//        Log.d("Test", "decodeToString >>> " + deStr);

        String input = "                        ";
        // Write your code here.
        String[] tokens = input.trim().split("[ !,?._'@]+");
        System.out.println("length = " + tokens.length);
        for(int i = 0; i < tokens.length; i++){
            System.out.printf("%d = %s", i, tokens[i]);
            System.out.println();
        }
        if(tokens[0].isEmpty()){
            System.out.println("0");
        }
//        for(String value: tokens){
//            System.out.println(value);
//            Log.d("Test", value);
//        }
    }
}