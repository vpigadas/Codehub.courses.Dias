package com.dias.course.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AndroidBaseViewModel extends AndroidViewModel {

    public AndroidBaseViewModel(@NonNull Application application) {
        super(application);
    }
}
