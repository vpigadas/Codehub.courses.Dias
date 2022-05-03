package com.dias.course.application.ui.home.fragments.poducts;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dias.course.R;
import com.dias.course.application.network.ApiClient;
import com.dias.course.application.network.ApiListResponse;
import com.dias.course.application.network.json.ProductsJsonModel;
import com.dias.course.application.utils.ListItemCallback;
import com.dias.course.application.ui.home.fragments.poducts.list.ProductAdapter;
import com.dias.course.application.ui.pay.PayActivity;

import java.util.List;

public class ProductFragment extends Fragment {

    public ProductFragment() {
        // Required empty public constructor
    }

    public static ProductFragment newInstance() {
        ProductFragment fragment = new ProductFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (hasTabletDevice()) {
            return inflater.inflate(R.layout.fragment_product, container, false);
        }else{
            return inflater.inflate(R.layout.fragment_product, container, false);

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewProducts);


        if (isPortraitMode()) {
            if (hasTabletDevice()) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        } else {
            if (hasTabletDevice()) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            }
        }

        ApiClient.getInstance().getProducts(new ApiListResponse<ProductsJsonModel>() {
            @Override
            public void onSuccess(List<ProductsJsonModel> dataList) {
                ProductAdapter adapter = new ProductAdapter(dataList, new ListItemCallback<ProductsJsonModel>() {
                    @Override
                    public void onClick(ProductsJsonModel data) {
                        Intent intent = new Intent(getContext(), PayActivity.class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                    }
                });

                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailed(Exception exception) {
                Toast.makeText(getContext(), exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected boolean hasTabletDevice() {
        boolean status = (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
        if (status)
            return true; //"Mobile"
        else
            return false; //"Tablet"
    }

    protected boolean isPortraitMode() {
        int status = getResources().getConfiguration().orientation;

        if (status == Configuration.ORIENTATION_PORTRAIT) {
            return true;
        } else {
            return false;
        }
    }
}