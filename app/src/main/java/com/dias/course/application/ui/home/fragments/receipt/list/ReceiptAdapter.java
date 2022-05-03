package com.dias.course.application.ui.home.fragments.receipt.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dias.course.R;
import com.dias.course.application.network.json.FinancialReceiptJsonModel;
import com.dias.course.application.utils.ListItemCallback;

import java.util.List;

public class ReceiptAdapter extends RecyclerView.Adapter<ReceiptViewHolder> {
    private List<FinancialReceiptJsonModel> arrayData;
    private ListItemCallback<FinancialReceiptJsonModel> callback;

    public ReceiptAdapter(List<FinancialReceiptJsonModel> arrayData, ListItemCallback<FinancialReceiptJsonModel> callback) {
        this.arrayData = arrayData;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ReceiptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_receipt_item, parent, false);
        return new ReceiptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceiptViewHolder holder, int position) {
        holder.bind(arrayData.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}
