package com.dias.course.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FViewModel extends ViewModel {

    private MutableLiveData<Boolean> streamBottomBtnClicked = new MutableLiveData<>();
    private MutableLiveData<String> streamLabel = new MutableLiveData<>();

    private String strName;

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public LiveData<Boolean> getStreamBottomBtnClicked() {
        return streamBottomBtnClicked;
    }

    public LiveData<String> getStreamLabel() {
        return streamLabel;
    }

    public String getLabel() {
        return streamLabel.getValue();
    }

    public void onBottomBtnClicked() {
        streamBottomBtnClicked.postValue(true);
    }

    public void setLabel(String name) {
        streamLabel.setValue(name);
    }
}
