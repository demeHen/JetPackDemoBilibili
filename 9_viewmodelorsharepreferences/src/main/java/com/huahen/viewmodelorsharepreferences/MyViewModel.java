package com.huahen.viewmodelorsharepreferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * Created by huahen on 2021/6/30
 * ClassDescription :
 */
public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle mHandle;
    private String key = getApplication().getResources().getString(R.string.my_data);
    private String NUMBER = getApplication().getResources().getString(R.string.config_number);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        mHandle = handle;
        //判断handle内是否存在对应值。此处为屏幕切换之类的保活
        if (!handle.contains(NUMBER)) {
            //不存在则从sharedPreferences中取出数据
            load();
        }
    }

    public LiveData<Integer> getNumber() {
        return mHandle.getLiveData(NUMBER);
    }


    //将ViewModel中的数据保存进SharedPreferences
    void save() {
        SharedPreferences sp = getApplication().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(NUMBER, getNumber().getValue());
        editor.apply();
    }

    //从sharedPreferences中取出数据，保存进viewModel
    private void load() {
        SharedPreferences sp = getApplication().getSharedPreferences(key, Context.MODE_PRIVATE);
        mHandle.set(NUMBER, sp.getInt(NUMBER, 0));
    }

    public void add(int i) {
        mHandle.set(NUMBER, getNumber().getValue() + i);
        //viewModel数据做出修改之后同步修改sp里的数据--也可以在Activity的onPause中调用。减少操作次数
//        save();
    }
}
