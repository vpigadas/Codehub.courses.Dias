package com.dias.course.application.network.json;

import java.io.Serializable;
import java.util.Objects;

public class FinancialReceiptJsonModel implements Serializable {
    private String receiptNumber;
    private String amount;
    private String currency;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialReceiptJsonModel that = (FinancialReceiptJsonModel) o;
        return Objects.equals(receiptNumber, that.receiptNumber) && Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptNumber, amount, currency);
    }

    @Override
    public String toString() {
        return "FinancialReceiptJsonModel{" +
                "receiptNumber='" + receiptNumber + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
