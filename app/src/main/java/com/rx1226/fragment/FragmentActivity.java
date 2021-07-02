package com.rx1226.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.R;
import com.rx1226.fragment.ui.main.MainFragment;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance(index++))
                    .commit();
        }

        Button btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_add){
            addFragment();
        }
    }

    private void addFragment(){
        clearBackStack(getSupportFragmentManager());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(index++))
                .addToBackStack("Fragment_" + index)
                .commit();
    }

    private void clearBackStack(FragmentManager fragmentManager) {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(0);
            fragmentManager.popBackStack(entry.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}