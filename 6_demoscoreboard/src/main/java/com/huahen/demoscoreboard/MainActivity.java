package com.huahen.demoscoreboard;

import android.os.Bundle;

import com.huahen.demoscoreboard.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mActivityMainBinding;
    ViewModelScoreBoardMe mViewModelScoreBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModelScoreBoard = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ViewModelScoreBoardMe.class);
        mActivityMainBinding.setData(mViewModelScoreBoard);
        mActivityMainBinding.setLifecycleOwner(this);

    }

    public void toUpActivity() {
//        startActivity(new Intent(MainActivity.this, UpActivity.class));
    }
}
