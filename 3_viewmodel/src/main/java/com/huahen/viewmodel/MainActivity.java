package com.huahen.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    MyViewModel mMyViewModel;
    TextView mTextView;
    Button mButton_1;
    Button mButton_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        mTextView = findViewById(R.id.textView);
        mButton_1 = findViewById(R.id.btn1);
        mButton_2 = findViewById(R.id.btn2);
        mTextView.setText(String.valueOf(mMyViewModel.number));

        mButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyViewModel.number++;
                mTextView.setText(String.valueOf(mMyViewModel.number));

            }
        });
        mButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyViewModel.number = mMyViewModel.number + 2;
                mTextView.setText(String.valueOf(mMyViewModel.number));

            }
        });
    }
}
