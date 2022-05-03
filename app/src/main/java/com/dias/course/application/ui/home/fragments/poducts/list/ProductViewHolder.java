package com.dias.course.application.ui.home.fragments.poducts.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dias.course.R;
import com.dias.course.application.network.json.ProductsJsonModel;
import com.dias.course.application.utils.ListItemCallback;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    public ProductViewHolder(@NonNull View itemView, ListItemCallback<ProductsJsonModel> callback) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemView.getTag() instanceof ProductsJsonModel) {
                    callback.onClick((ProductsJsonModel) itemView.getTag());
                }
            }
        });
    }

    public void bind(ProductsJsonModel data) {
        itemView.setTag(data);

        TextView title = itemView.findViewById(R.id.holder_product_title);
        title.setText(data.getName());

        TextView price = itemView.findViewById(R.id.holder_product_price);
        price.setText(String.valueOf(data.getAmount()));

        ImageView imageView = itemView.findViewById(R.id.holder_product_img);
        imageView.setImageResource(getImage(data.getSlug()));
    }

    private int getImage(String name) {
        switch (name) {
            case "apple":
                return R.drawable.apple;
            case "orange":
                return R.drawable.orange;
            case "pear":
                return R.drawable.pear;
            case "peach":
                return R.drawable.peach;
            case "grapefruit":
                return R.drawable.grapefruit;
            case "apricot":
                return R.drawable.apricot;
            case "black_cherry":
                return R.drawable.cherry;
            case "red-cherry":
                return R.drawable.cherry;
            case "grapes":
                return R.drawable.grapes;
            case "mandarin":
                return R.drawable.mandarin;
            case "watermelon":
                return R.drawable.watermelon;
            case "melon":
                return R.drawable.melon;
            case "lemon":
                return R.drawable.lemon;
            case "blueberry":
                return R.drawable.blueberry;
            case "mango":
                return R.drawable.mango;
            default:
                return R.mipmap.ic_launcher;
        }
    }
}
