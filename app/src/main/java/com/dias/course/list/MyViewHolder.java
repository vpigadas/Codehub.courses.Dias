package com.dias.course.list;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dias.course.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(String data) {
        TextView textView = itemView.findViewById(R.id.holder_item_title);
        textView.setText(data);
    }
}
