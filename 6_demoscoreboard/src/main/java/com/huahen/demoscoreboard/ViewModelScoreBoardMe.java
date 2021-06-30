package com.huahen.demoscoreboard;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by huahen on 2021/6/24
 *
 * ClassDescription :
 */
public class ViewModelScoreBoardMe extends ViewModel {
    private MutableLiveData<Integer> LiveNumberBlue;
    private MutableLiveData<Integer> LiveNumberRed;
    private MutableLiveData<List<oldData>> LiveNumberOld;//历史记录


    public MutableLiveData<Integer> getLiveNumberBlue() {
        if (LiveNumberBlue == null) {
            LiveNumberBlue = new MediatorLiveData<>();
            LiveNumberBlue.setValue(0);
        }
        if (LiveNumberOld == null) {
            LiveNumberOld = new MediatorLiveData<>();
            LiveNumberOld.setValue(new ArrayList<oldData>());
        }
        return LiveNumberBlue;
    }

    public MutableLiveData<Integer> getLiveNumberRed() {
        if (LiveNumberRed == null) {
            LiveNumberRed = new MediatorLiveData<>();
            LiveNumberRed.setValue(0);
        }
        if (LiveNumberOld == null) {
            LiveNumberOld = new MediatorLiveData<>();
            LiveNumberOld.setValue(new ArrayList<oldData>());
        }
        return LiveNumberRed;
    }

    public void addLiveNumber(int n, boolean b) {
        if (b) {
            LiveNumberOld.getValue().add(new oldData(b, LiveNumberBlue.getValue()));
            LiveNumberBlue.setValue(LiveNumberBlue.getValue() + n);
        } else {
            LiveNumberOld.getValue().add(new oldData(b, LiveNumberRed.getValue()));
            LiveNumberRed.setValue(LiveNumberRed.getValue() + n);
        }
    }

    /**
     * 撤销-返回上一步操作。
     */
    public void revoke() {
        if (LiveNumberOld.getValue() != null && LiveNumberOld.getValue().size() > 0) {
            //判断数列中最后一个的归属。进行显示处理。
            if (LiveNumberOld.getValue().get(LiveNumberOld.getValue().size() - 1).type) {
                LiveNumberBlue.setValue(LiveNumberOld.getValue().get(LiveNumberOld.getValue().size() - 1).number);//取最后一个值
            } else {
                LiveNumberRed.setValue(LiveNumberOld.getValue().get(LiveNumberOld.getValue().size() - 1).number);//取最后一个值
            }
            //删除
            LiveNumberOld.getValue().remove(LiveNumberOld.getValue().size() - 1);//清除最后一个值
        }
    }

    /**
     * 清除所有数值
     */
    public void clean() {
        LiveNumberBlue.setValue(0);
        LiveNumberRed.setValue(0);
        LiveNumberOld.setValue(new ArrayList<oldData>());
    }

    static class oldData {
        boolean type;
        int number;

        oldData(boolean type, int number) {
            this.type = type;
            this.number = number;
        }
    }
}
