package com.dias.course.list;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AbstractViewHolder extends RecyclerView.ViewHolder {
    public AbstractViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(UiModel data);
}
