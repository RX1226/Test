package com.rx1226.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.test.R;
import com.example.test.databinding.ActivityDataBindingBinding;
import com.rx1226.databinding.viewmodel.DataBindingViewModel;

public class DataBindingActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityDataBindingBinding binding;
    private DataBindingViewModel viewModel;
    private MutableLiveData<Integer> currentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DataBindingViewModel.class);
//        setContentView(R.layout.activity_data_binding);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        binding.setLifecycleOwner(this);
        currentCount = new MutableLiveData<>();
        currentCount.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.txtNumber.setText("Number = " + integer);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_set:
                binding.txtName.setText("Name");
                viewModel.count++;
//                binding.txtNumber.setText("Number = " + viewModel.count);
                currentCount.postValue(viewModel.count);
                break;
            case R.id.btn_rotation:
                if(getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                break;
        }
    }
}
