package com.dias.course.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dias.course.R;

public class MainActivity extends AppCompatActivity {

    private BaseViewModel viewModel;
    private AndroidBaseViewModel androidViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(BaseViewModel.class);
        androidViewModel = new ViewModelProvider(this).get(AndroidBaseViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        viewModel.getStream().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
    }

    @Override
    protected void onStop() {
        viewModel.getStream().removeObservers(this);
        super.onStop();
    }
}