package com.dias.course.application.network;

import androidx.annotation.NonNull;

import com.dias.course.application.network.json.FinancialReceiptJsonModel;
import com.dias.course.application.network.json.ProductsJsonModel;
import com.dias.course.application.network.json.RequestPayModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient instance;
    private JsonApi api;

    @NonNull
    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
            instance.initialise();
        }

        return instance;
    }

    private void initialise() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-vpigadas.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(JsonApi.class);
    }

    public void getProducts(ApiListResponse<ProductsJsonModel> callback) {
        api.getProducts().enqueue(new Callback<List<ProductsJsonModel>>() {
            @Override
            public void onResponse(Call<List<ProductsJsonModel>> call, Response<List<ProductsJsonModel>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailed(new Exception(response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<List<ProductsJsonModel>> call, Throwable t) {
                callback.onFailed(new Exception(t));
            }
        });
    }

    public void getReceipts() {
        api.getTransactions().enqueue(new Callback<List<FinancialReceiptJsonModel>>() {
            @Override
            public void onResponse(Call<List<FinancialReceiptJsonModel>> call, Response<List<FinancialReceiptJsonModel>> response) {

            }

            @Override
            public void onFailure(Call<List<FinancialReceiptJsonModel>> call, Throwable t) {

            }
        });
    }

    public void pay(String amount, ApiResponse<FinancialReceiptJsonModel> callback) {
        RequestPayModel model = new RequestPayModel();
        model.setAmount(amount);

        api.transactionPay(model).enqueue(new Callback<FinancialReceiptJsonModel>() {
            @Override
            public void onResponse(Call<FinancialReceiptJsonModel> call, Response<FinancialReceiptJsonModel> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailed(new Exception(response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<FinancialReceiptJsonModel> call, Throwable t) {
                callback.onFailed(new Exception(t));
            }
        });
    }
}
