package com.huahen.viewmodelsavestate;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by huahen on 2021/6/29
 * ClassDescription :
 */
public class MyViewModel extends ViewModel {

    private MediatorLiveData<Integer> number;

    public MediatorLiveData<Integer> getNumber() {
        if (number==null){
            number = new MediatorLiveData<>();
            number.setValue(0);
        }
        return number;
    }
    public void addNumber(){
        number.setValue(number.getValue()+1);
    }
}
