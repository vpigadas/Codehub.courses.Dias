package com.dias.course.application.network.json;

import java.io.Serializable;
import java.util.Objects;

public class IRISResponse implements Serializable {
    private String initiatingPartyRefId;
    private String orderId;
    private String bankSelectionToolUrl;

    public String getInitiatingPartyRefId() {
        return initiatingPartyRefId;
    }

    public void setInitiatingPartyRefId(String initiatingPartyRefId) {
        this.initiatingPartyRefId = initiatingPartyRefId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBankSelectionToolUrl() {
        return bankSelectionToolUrl;
    }

    public void setBankSelectionToolUrl(String bankSelectionToolUrl) {
        this.bankSelectionToolUrl = bankSelectionToolUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IRISResponse that = (IRISResponse) o;
        return Objects.equals(initiatingPartyRefId, that.initiatingPartyRefId) && Objects.equals(orderId, that.orderId) && Objects.equals(bankSelectionToolUrl, that.bankSelectionToolUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initiatingPartyRefId, orderId, bankSelectionToolUrl);
    }

    @Override
    public String toString() {
        return "IRISResponse{" +
                "initiatingPartyRefId='" + initiatingPartyRefId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", bankSelectionToolUrl='" + bankSelectionToolUrl + '\'' +
                '}';
    }
}
