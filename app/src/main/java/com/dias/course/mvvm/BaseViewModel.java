package com.dias.course.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    private MutableLiveData<String> stream = new MutableLiveData<>();

    public LiveData<String> getStream() {
        return stream;
    }




}
