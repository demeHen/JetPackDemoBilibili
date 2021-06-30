package com.huahen.databinding;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by huahen on 2021/6/24
 *
 * ClassDescription :
 */
public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> LiveNumber;

    public MutableLiveData<Integer> getLiveNumber() {
        if (LiveNumber == null) {
            LiveNumber = new MediatorLiveData<>();
            LiveNumber.setValue(0);
        }
        return LiveNumber;
    }

    public void addLiveNumber(int n) {
        LiveNumber.setValue(LiveNumber.getValue() + n);
    }
}
