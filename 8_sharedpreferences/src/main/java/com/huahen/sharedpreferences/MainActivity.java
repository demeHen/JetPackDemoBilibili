package com.huahen.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////////////////////-----1
        //声明--文件可以在Data-data-包名-对应文件夹中找到
//        SharedPreferences sp = getPreferences( Context.MODE_PRIVATE);//不设置文件名称，以当前Activity为文件名
        SharedPreferences sp = getSharedPreferences(Config.FILENAME, Context.MODE_PRIVATE);//设置名称，适合共享

        //写入数据
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(Config.NUMBER, 100);//根据键值写入数据
        editor.apply();//提交修改-异步
//        editor.commit();//提交修改-同步-不建议使用--

        //读取数据
        int x = sp.getInt(Config.NUMBER, 0);//读取。第一个参数为对应键值。后面为缺省值（为空的时候的默认值）
        Log.d(TAG, String.valueOf(x));

        //////////////////////////////////////-----2
        //此处用全局上下文不用this的原因是为了防止内存泄漏、减少代码耦合。因为存在着activity被回收。但是myData还持有着它的情况
        MyData myData = new MyData(getApplicationContext());
        myData.number = 100;
        myData.save();//存
        Log.d(TAG, String.valueOf(myData.load()));//取

    }
}
