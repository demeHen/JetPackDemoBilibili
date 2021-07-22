package com.huahen.lifecycles;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        MyChronometer myChronometer = findViewById(R.id.meter);
        getLifecycle().addObserver(myChronometer);
    }
}
