package com.huahen.viewmodelsavestate;

import android.os.Bundle;

import com.huahen.viewmodelsavestate.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    final String KEY_NUMBER = "KEY_NUMBER";
    ActivityMainBinding mActivityMainBinding;
    MyViewModelSaveSate mMyViewModelSaveSate;
    //TODO demo1
//    MyViewModel mMyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMyViewModelSaveSate = new ViewModelProvider(this).get(MyViewModelSaveSate.class);
        mActivityMainBinding.setData(mMyViewModelSaveSate);
        mActivityMainBinding.setLifecycleOwner(this);
        //TODO demo1
//        mMyViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
//        if (savedInstanceState != null) {//不为空
//            mMyViewModel.getNumber().setValue(savedInstanceState.getInt(KEY_NUMBER));//读
//        }
//        mActivityMainBinding.setData(mMyViewModel);
//        mActivityMainBinding.setLifecycleOwner(this);
    }

    //TODO demo1
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_NUMBER, mMyViewModel.getNumber().getValue());//写
//    }
}
