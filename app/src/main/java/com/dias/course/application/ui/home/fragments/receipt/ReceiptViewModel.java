package com.dias.course.application.ui.home.fragments.receipt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dias.course.application.network.ApiClient;
import com.dias.course.application.network.ApiListResponse;
import com.dias.course.application.network.json.FinancialReceiptJsonModel;
import com.dias.course.application.ui.home.fragments.receipt.list.ReceiptAdapter;
import com.dias.course.application.utils.ListItemCallback;

import java.util.ArrayList;
import java.util.List;

public class ReceiptViewModel extends ViewModel {

    private MutableLiveData<ReceiptAdapter> streamAdapter = new MutableLiveData<ReceiptAdapter>();

    public LiveData<ReceiptAdapter> getStreamAdapter() {
        return streamAdapter;
    }

    public void populateList() {
        ApiClient.getInstance().getReceipts(new ApiListResponse<FinancialReceiptJsonModel>() {
            @Override
            public void onSuccess(List<FinancialReceiptJsonModel> dataList) {
                List<FinancialReceiptJsonModel> list = new ArrayList<>();
                if (dataList != null) {
                    list.addAll(dataList);
                }

                ReceiptAdapter adapter = new ReceiptAdapter(list, new ListItemCallback<FinancialReceiptJsonModel>() {
                    @Override
                    public void onClick(FinancialReceiptJsonModel data) {

                    }
                });
                streamAdapter.postValue(adapter);
            }

            @Override
            public void onFailed(Exception exception) {

            }
        });
    }
}
