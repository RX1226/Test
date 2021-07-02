package com.rx1226.addView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.databinding.ActivityAddViewBinding;
import com.example.test.databinding.ActivityDataBindingBinding;
import com.rx1226.fragment.ui.main.MainFragment;

public class AddViewActivity extends AppCompatActivity {
    private ActivityAddViewBinding binding;
    private Context context;
    private LinearLayout root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_view);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_view);

        this.context = this;
//        root = findViewById(R.id.root);

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, new AddViewFragment())
//                .commit();

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button textView = new Button(context);
                textView.setText("Gooood");
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                textView.setLayoutParams(layoutParams);
                binding.root.addView(textView);
            }
        });
    }
}