package com.huahen.democount;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.concurrent.ThreadLocalRandom;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * Created by huahen on 2021/7/6
 * ClassDescription :
 */
public class MyViewModel extends AndroidViewModel {
    String HighNumber = getApplication().getString(R.string.key_number);
    String FileName = getApplication().getString(R.string.key_file_name);
    private SavedStateHandle mHandle;
    private MutableLiveData<Integer> number;


    //////////当前分数//////////

    public MutableLiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    @SuppressWarnings("ConstantConditions")
    public void addNumber() {
        number.setValue(number.getValue() + 1);
    }

    public void cleanNumber() {
        number.setValue(0);
    }


    //////////最高分数//////////

    public MyViewModel(@NonNull Application application, SavedStateHandle savedStateHandle) {
        super(application);
        mHandle = savedStateHandle;
        if (!mHandle.contains(HighNumber)) {
            loadHighNumber();
        }
    }

    public LiveData<Integer> getHighNumber() {
        return mHandle.getLiveData(HighNumber);
    }

    //加载
    public void loadHighNumber() {
        SharedPreferences sp = getApplication().getSharedPreferences(FileName, Context.MODE_PRIVATE);
        sp.getInt(HighNumber, 0);
    }

    //保存
    @SuppressWarnings("ConstantConditions")
    public void saveHighNumber() {
        SharedPreferences sp = getApplication().getSharedPreferences(FileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(HighNumber, getHighNumber().getValue());
        editor.apply();
    }


    //更新最高纪录两种方法。2:每次答题正确更新数据
    @SuppressWarnings("ConstantConditions")
    public void updateHighNumber(int i) {
        //判断新数据是否大于之前最高纪录值
        if (i > getHighNumber().getValue()) {
            saveHighNumber();
        }
    }

    //////////获取算式//////////
    private MutableLiveData<Integer> answer;
    private MutableLiveData<String> countStr;

    //获取算式，并保存响应结果
    public MutableLiveData<String> getCountStr() {
        if (answer == null) {
            answer = new MediatorLiveData<>();
            answer.setValue(0);
        }
        if (countStr == null) {
            countStr = new MediatorLiveData<>();
            countStr.setValue(getNewCountStr());
        }
        return countStr;
    }

    public void updateCountStr() {
        countStr.setValue(getNewCountStr());
    }

    private String getNewCountStr() {
        isPush = true;
        int numOne = ThreadLocalRandom.current().nextInt(1, 21);
        int numTow = ThreadLocalRandom.current().nextInt(0, numOne);
        int count = ThreadLocalRandom.current().nextInt(0, 3);

        String str = "";

        switch (count) {
            case 0:
                str = numOne + " + " + numTow + " = ?";
                answer.setValue(numOne + numTow);
                break;
            case 1:
                str = numOne + " - " + numTow + " = ?";
                answer.setValue(numOne - numTow);
                break;
            case 2:
                str = numOne + " * " + numTow + " = ?";
                answer.setValue(numOne * numTow);
                break;
            default:
                break;
        }
        return str;
    }

    //输入结果
    boolean isPush = false;//是否提交

    private MutableLiveData<String> tipStr;

    public MutableLiveData<String> getTipStr() {
        if (tipStr == null) {
            tipStr = new MediatorLiveData<>();
            tipStr.setValue(getApplication().getString(R.string.start_answer));
        }
        return tipStr;
    }

    public void addTipStr(String i) {
        if (isPush) {
            tipStr.setValue("");
        }
        isPush = false;
        tipStr.setValue(tipStr.getValue() + i);
    }

    public void cleanTipStr() {
        tipStr.setValue("");
    }

    public boolean pushTipStr() {
        if (isPush) {
            return false;
        }
        int meAnswer = Integer.parseInt(tipStr.getValue());
        if (meAnswer == answer.getValue()) {
            addNumber();
            updateCountStr();
            return false;
        } else {
            return true;
        }
    }
}
