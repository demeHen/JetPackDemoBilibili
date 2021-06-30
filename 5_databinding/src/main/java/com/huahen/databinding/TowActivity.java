package com.huahen.databinding;

import android.os.Bundle;

import com.huahen.databinding.databinding.ActivityTowBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class TowActivity extends AppCompatActivity {


    ViewModelWithLiveData mViewModelWithLiveData;
    ActivityTowBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_tow);
        mViewModelWithLiveData = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ViewModelWithLiveData.class);

        mActivityMainBinding.setData(mViewModelWithLiveData);
        mActivityMainBinding.setLifecycleOwner(this);//必须-监听
    }
}
