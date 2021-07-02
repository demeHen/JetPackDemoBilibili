package com.huahen.viewmodelorsharepreferences;

import android.os.Bundle;

import com.huahen.viewmodelorsharepreferences.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mActivityMainBinding;
    MyViewModel mMyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMyViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        mActivityMainBinding.setData(mMyViewModel);
        mActivityMainBinding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMyViewModel.save();//可处理大部分情况
    }
}
