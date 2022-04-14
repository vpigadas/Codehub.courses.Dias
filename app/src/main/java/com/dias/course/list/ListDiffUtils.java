package com.dias.course.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class ListDiffUtils extends DiffUtil.ItemCallback<UiModel> {

    @Override
    public boolean areItemsTheSame(@NonNull UiModel oldItem, @NonNull UiModel newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull UiModel oldItem, @NonNull UiModel newItem) {
        return oldItem.equals(newItem);
    }
}
