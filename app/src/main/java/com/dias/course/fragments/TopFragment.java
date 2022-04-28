package com.dias.course.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dias.course.R;

public class TopFragment extends Fragment {

    private FViewModel viewModel;

    public TopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getActivity() != null) {
            viewModel = new ViewModelProvider(getActivity()).get(FViewModel.class);
        } else {
            viewModel = new ViewModelProvider(this).get(FViewModel.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnLeft = view.findViewById(R.id.top_btn_left);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setLabel("LEFT");
            }
        });

        Button btnRight = view.findViewById(R.id.top_btn_right);
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setLabel("RIGHT");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        View view = getView();
    }
}