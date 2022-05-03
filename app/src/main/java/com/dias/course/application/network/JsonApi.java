package com.dias.course.application.network;

import com.dias.course.application.network.json.FinancialReceiptJsonModel;
import com.dias.course.application.network.json.IRISResponseModel;
import com.dias.course.application.network.json.ProductsJsonModel;
import com.dias.course.application.network.json.RequestPayModel;
import com.dias.course.application.network.json.RequestRefundModel;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonApi {
    String PATH = "/api/printec/financial/";

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET(PATH + "products")
    Call<List<ProductsJsonModel>> getProducts();

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET(PATH + "receipts")
    Call<List<FinancialReceiptJsonModel>> getTransactions();

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST(PATH + "pay")
    Call<FinancialReceiptJsonModel> transactionPay(@Body RequestPayModel body);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST(PATH + "refund")
    Call<FinancialReceiptJsonModel> transactionRefund(@Body RequestRefundModel body);

    @Headers({
            "Content-Type: application/json;charset=UTF-8"
    })
    @POST("https://test-iris.dias.com.gr/iris-ecommerce-msp/api/register-order-request")
    Call<IRISResponseModel> getIrisURL(@Body JsonObject body);
}
