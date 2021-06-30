package com.huahen.livedata;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    ViewModelWithLiveData mViewModelWithLiveData;
    TextView mTextView;
    ImageButton mImageButton1, mImageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
        mImageButton1 = findViewById(R.id.imageButton);
        mImageButton2 = findViewById(R.id.imageButton2);
        mViewModelWithLiveData = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ViewModelWithLiveData.class);
        mViewModelWithLiveData.getLiveNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTextView.setText(String.valueOf(integer));
            }
        });

        mImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModelWithLiveData.addLiveNumber(1);
            }
        });
        mImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModelWithLiveData.addLiveNumber(-1);
            }
        });
    }
}
