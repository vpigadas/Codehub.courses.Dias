package com.dias.course.application.ui.home.fragments.poducts.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dias.course.R;
import com.dias.course.application.network.json.ProductsJsonModel;
import com.dias.course.application.utils.ListItemCallback;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<ProductsJsonModel> arrayData;
    private ListItemCallback<ProductsJsonModel> callback;

    public ProductAdapter(List<ProductsJsonModel> arrayData, ListItemCallback<ProductsJsonModel> callback) {
        this.arrayData = arrayData;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_product_item, parent, false);
        return new ProductViewHolder(view, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(arrayData.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}
