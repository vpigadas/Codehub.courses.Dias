package com.dias.course.application.ui.home.fragments.receipt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.dias.course.R;
import com.dias.course.application.ui.home.fragments.receipt.list.ReceiptAdapter;

public class ReceiptFragment extends Fragment {
    private ReceiptViewModel receiptViewModel;

    public ReceiptFragment() {
        // Required empty public constructor
    }

    public static ReceiptFragment newInstance() {
        ReceiptFragment fragment = new ReceiptFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        receiptViewModel = new ViewModelProvider(this).get(ReceiptViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receipt, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        receiptViewModel.getStreamAdapter().observe(getViewLifecycleOwner(), new Observer<ReceiptAdapter>() {
            @Override
            public void onChanged(ReceiptAdapter receiptAdapter) {
                RecyclerView recyclerView = view.findViewById(R.id.recyclerViewReceipts);
                recyclerView.setAdapter(receiptAdapter);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        receiptViewModel.populateList();
    }
}