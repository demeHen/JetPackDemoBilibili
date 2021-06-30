package com.huahen.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.huahen.databinding.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {


    ViewModelWithLiveData mViewModelWithLiveData;
    //1，声明binding。类名一般为xml名字开头
    ActivityMainBinding mActivityMainBinding;

    //    TextView mTextView;
    //    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //2，原来的setContentView改为DataBindingUtil.setContentView()
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //        setContentView(R.layout.activity_main);

        mViewModelWithLiveData = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ViewModelWithLiveData.class);

        //到此，对于xml中控件的使用不需要先声明然后在findViewById来使用。直接通过binding对象来引用
        //如下。修改文本值，设置按钮事件


        mViewModelWithLiveData.getLiveNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mActivityMainBinding.textview.setText(String.valueOf(integer));
//                mTextView.setText(String.valueOf(integer));
            }
        });
        mActivityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModelWithLiveData.addLiveNumber(1);
            }
        });
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mViewModelWithLiveData.addLiveNumber(1);
//            }
//        });

        //这里放这一个方法跳到towActivity。
        mActivityMainBinding.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TowActivity.class));
            }
        });
    }
}
