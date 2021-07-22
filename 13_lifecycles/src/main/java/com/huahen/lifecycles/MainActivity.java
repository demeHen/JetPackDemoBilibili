package com.huahen.lifecycles;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.huahen.lifecycles.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mActivityMainBinding;
    private long elapsedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        //UNIX时间 从1970 1-1 到现在时间经过的毫秒数
//        System.currentTimeMillis();
//        //手机从上次启动到现在时间经过的毫秒数
//        SystemClock.elapsedRealtime();
        mActivityMainBinding.meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivityMainBinding.meter.setBase(SystemClock.elapsedRealtime() - elapsedTime);
        mActivityMainBinding.meter.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        elapsedTime = SystemClock.elapsedRealtime() - mActivityMainBinding.meter.getBase();
        mActivityMainBinding.meter.stop();
    }
}
