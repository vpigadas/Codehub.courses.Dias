package com.dias.course.list;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.dias.course.R;

public class MyListViewHolder extends AbstractViewHolder {

    private UIItemListener listener;

    public MyListViewHolder(@NonNull View itemView, UIItemListener listener) {
        super(itemView);
        this.listener = listener;
    }

    public void bind(UiModel data) {
        TextView textView = itemView.findViewById(R.id.holder_item_title);
        textView.setText(data.getName());

        ImageView img = itemView.findViewById(R.id.holder_item_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v,data);
            }
        });
    }
}
