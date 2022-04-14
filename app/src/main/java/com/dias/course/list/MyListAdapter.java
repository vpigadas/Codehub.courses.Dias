package com.dias.course.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.dias.course.R;

public class MyListAdapter extends ListAdapter<UiModel, AbstractViewHolder> {

    private UIItemListener listener;

    protected MyListAdapter(UIItemListener listener) {
        super(new ListDiffUtils());
        this.listener = listener;
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        if (viewType == R.layout.holder_list_item) {
            return new MyListViewHolder(view, listener);
        } else {
            return new MyListViewHolder(view, listener);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return R.layout.holder_list_item;
        } else {
            return R.layout.holder_list_item;
        }
    }
}
