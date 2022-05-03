package com.dias.course.application.network;

import androidx.annotation.NonNull;

import com.dias.course.application.network.json.FinancialReceiptJsonModel;
import com.dias.course.application.network.json.IRISResponseModel;
import com.dias.course.application.network.json.ProductsJsonModel;
import com.dias.course.application.network.json.RequestPayModel;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

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

    public void getReceipts(ApiListResponse<FinancialReceiptJsonModel> callback) {
        api.getTransactions().enqueue(new Callback<List<FinancialReceiptJsonModel>>() {
            @Override
            public void onResponse(Call<List<FinancialReceiptJsonModel>> call, Response<List<FinancialReceiptJsonModel>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailed(new Exception(response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<List<FinancialReceiptJsonModel>> call, Throwable t) {
                callback.onFailed(new Exception(t));
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

    public void getIris(Double amount, ApiResponse<IRISResponseModel> callback) {
        Calendar calendar = Calendar.getInstance();

        String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).format(calendar.getTime());
        String messageId = new SimpleDateFormat("yyMMddHHmmss", Locale.getDefault()).format(calendar.getTime());


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userName", "irisUser90001");
        jsonObject.addProperty("password", "1234");
        jsonObject.addProperty("messageId", messageId);
        jsonObject.addProperty("creationDateTime", timestamp);
        jsonObject.addProperty("initiatingPartyRefId", messageId);
        jsonObject.addProperty("validityPeriod", "18");
        jsonObject.addProperty("initiatingPartyReturnURL", "https://www.emerchant-site-page.com/callback?language=el&initiatingPartyRefId=38bed40e3995fe546ed534acce619ee4");
        jsonObject.addProperty("instructedAmount", Math.round(amount));

//        String currencyCode = Currency.getInstance(Locale.getDefault()).getCurrencyCode();
//
//        jsonObject.addProperty("currency", currencyCode);
        jsonObject.addProperty("currency","EUR");

        JsonObject jsonRemittanceInfo = new JsonObject();
        jsonRemittanceInfo.addProperty("unstructured1", "test");
        jsonRemittanceInfo.addProperty("unstructured2", "00000001234555500128");

        jsonObject.add("remittanceInfo", jsonRemittanceInfo);
        jsonObject.addProperty("language", "el");


        api.getIrisURL(jsonObject).enqueue(new Callback<IRISResponseModel>() {
            @Override
            public void onResponse(Call<IRISResponseModel> call, Response<IRISResponseModel> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailed(new Exception(response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<IRISResponseModel> call, Throwable t) {
                callback.onFailed(new Exception(t));

            }
        });
    }
}
