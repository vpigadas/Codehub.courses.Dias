package com.dias.course.application.network.json;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class RequestRefundModel {

    @SerializedName(value = "receipt_number")
    private String receiptNumber;
    private String amount;

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestRefundModel that = (RequestRefundModel) o;
        return Objects.equals(receiptNumber, that.receiptNumber) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptNumber, amount);
    }

    @Override
    public String toString() {
        return "RequestRefundModel{" +
                "receiptNumber='" + receiptNumber + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
