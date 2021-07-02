package com.huahen.navigation.viewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by huahen on 2021/7/2
 * ClassDescription :
 */
public class MyViewModel extends ViewModel {
    private MediatorLiveData<Integer> number;

    public MediatorLiveData<Integer> getNumber() {
        if (number == null) {
            number = new MediatorLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    @SuppressWarnings("ConstantConditions")
    public void add(int i) {
        number.setValue(number.getValue() + i);
        if (number.getValue() < 0) {
            number.setValue(0);
        }
    }
}
