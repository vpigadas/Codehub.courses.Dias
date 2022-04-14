package com.dias.course;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        startOperations();
    }

    protected abstract void startOperations();

    @Override
    protected void onPause() {
        stopOperations();
        super.onPause();
    }

    protected abstract void stopOperations();
}
