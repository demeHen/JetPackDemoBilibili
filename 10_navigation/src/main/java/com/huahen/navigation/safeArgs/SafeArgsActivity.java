package com.huahen.navigation.safeArgs;

import android.os.Bundle;

import com.huahen.navigation.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by huahen on 2021/5/29
 * Version:v5.0.0
 * ClassDescription :
 */
public class SafeArgsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_args);
    }
}
