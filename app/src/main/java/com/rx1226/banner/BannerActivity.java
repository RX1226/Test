package com.rx1226.banner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        viewPager = findViewById(R.id.viewpager2);
        List<String> list = new ArrayList<>();
        list.add("页面一");
        list.add("页面二");
        list.add("页面三");
        list.add("页面四");
        viewPager.setAdapter(new ViewPagerAdapter(this, list));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_before:
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                break;
            case R.id.btn_next:
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                break;
        }
    }
}