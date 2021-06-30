package com.huahen.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by huahen on 2021/6/30
 * ClassDescription :
 */
public class MyData {
    public int number;
    private Context mContext;

    public MyData(Context context) {
        mContext = context;
    }

    public void save() {
        SharedPreferences sp = mContext.getSharedPreferences(Config.FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(Config.NUMBER, number);
        editor.apply();
    }

    public int load() {
        //这边举例两种固定数据的引用。
        //1，创建一个类。类静态变量引用 Config.FILENAME
        SharedPreferences sp = mContext.getSharedPreferences(Config.FILENAME, Context.MODE_PRIVATE);
        //2，资源文件指向引用 mContext.getResources().getInteger(R.integer.defValue)
        number = sp.getInt(Config.NUMBER, mContext.getResources().getInteger(R.integer.defValue));
        return number;

        //两种方法都是为了易于维护项目去写的
    }
}
