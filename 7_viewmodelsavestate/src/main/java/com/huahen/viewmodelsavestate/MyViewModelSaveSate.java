package com.huahen.viewmodelsavestate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * Created by huahen on 2021/6/29
 * ClassDescription :
 */
public class MyViewModelSaveSate extends ViewModel {
    private SavedStateHandle handler;

    public MyViewModelSaveSate(SavedStateHandle handler) {
        //判断handler内是否有NUMBER的值
        if (!handler.contains("NUMBER")) {
            handler.set("NUMBER", 0);
        }
        this.handler = handler;
    }


    public LiveData<Integer> getNumber() {
        return handler.getLiveData("NUMBER");
    }

    public void add() {
        handler.set("NUMBER", (int) handler.get("NUMBER") + 1);
    }
}
