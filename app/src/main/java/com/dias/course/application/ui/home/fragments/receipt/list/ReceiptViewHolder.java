package com.dias.course.application.ui.home.fragments.receipt.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dias.course.R;
import com.dias.course.application.network.json.FinancialReceiptJsonModel;

public class ReceiptViewHolder extends RecyclerView.ViewHolder {
    public ReceiptViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(FinancialReceiptJsonModel data) {
        TextView receipt = itemView.findViewById(R.id.holder_receipt_number);
        receipt.setText(data.getReceiptNumber());
        TextView amount = itemView.findViewById(R.id.holder_receipt_amount);
        amount.setText(data.getAmount() + data.getCurrency());
    }
}
