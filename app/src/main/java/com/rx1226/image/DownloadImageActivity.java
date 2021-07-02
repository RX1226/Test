package com.rx1226.image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.test.R;
import com.squareup.picasso.Picasso;

public class DownloadImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);


        String imgUrl = "https://www.zoo.gov.tw/iTAP/05_Exhibit/02_ChildrenZoo.jpg";
//        String imgUrl = "http://www.arno.tw/images/article/201211/want-to-do-internet-marketing/want-to-do-internet-marketing.jpg";
//        String imgUrl = "https://www-ws.gov.taipei/001/Upload/621/relpic/28712/7949529/ecad9706-f4a7-4a37-9cf7-037eca67c87c.jpg";
        ImageView img = findViewById(R.id.img);

        Glide
                .with(this)
                .load(imgUrl)
                .into(img);

//        Picasso.get()
//                .load(imgUrl)
//                .into(img);
    }
}