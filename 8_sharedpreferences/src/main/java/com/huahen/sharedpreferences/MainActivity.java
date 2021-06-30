package com.huahen.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPreferences sp = getPreferences( Context.MODE_PRIVATE);//不设置文件名称，以当前Activity为文件名
        SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);//设置名称，适合共享
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("NUMBER", 100);//根据键值写入数据
        editor.apply();//提交修改
    }
}
