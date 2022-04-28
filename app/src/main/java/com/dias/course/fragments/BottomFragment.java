package com.dias.course.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dias.course.R;

public class BottomFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private FViewModel viewModel;


    public BottomFragment() {
        // Required empty public constructor
    }

    public static BottomFragment newInstance(String param1) {
        BottomFragment fragment = new BottomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public static BottomFragment newInstance() {
        BottomFragment fragment = new BottomFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

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
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.bottom_txt_label);
        if (mParam1 != null) {
            textView.setText(mParam1);
        }

        Button button = view.findViewById(R.id.bottom_btn_close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Activity activity = getActivity();
//
//                if (activity != null && !(activity.isFinishing() || activity.isDestroyed())) {
//                    activity.finish();
//                }

                viewModel.onBottomBtnClicked();
            }
        });

        viewModel.getStreamLabel().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView textView = view.findViewById(R.id.bottom_txt_label);
                if (s != null) {
                    textView.setText(s);
                }
            }
        });

        String name = viewModel.getLabel();
    }
}