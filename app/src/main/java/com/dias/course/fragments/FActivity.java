package com.dias.course.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dias.course.R;
import com.dias.course.databinding.ActivityFactivityBinding;

public class FActivity extends AppCompatActivity {

    private BottomFragment bottomFragment;
    private FViewModel viewModel;

    private ActivityFactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factivity);

        binding = ActivityFactivityBinding.inflate(LayoutInflater.from(this));

        bottomFragment = BottomFragment.newInstance("Vassilis");

        viewModel = new ViewModelProvider(this).get(FViewModel.class);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


        TopFragment topFragment = new TopFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(topFragment,"TOPFRAGMENT");
        //transaction.add(bottomFragment, "BOTTOMFRAGMENT");
        transaction.add(R.id.top_container, topFragment, "TOPFRAGMENT");
        transaction.commit();

        findViewById(R.id.activity_btn);

        binding.activityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        viewModel.getStreamBottomBtnClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    finish();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.bottom_container, bottomFragment, "BOTTOMFRAGMENT");
        transaction.commit();

        viewModel.setLabel("Orfeas");
    }
}