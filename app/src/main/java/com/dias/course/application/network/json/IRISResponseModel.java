package com.dias.course.application.network.json;

import java.io.Serializable;
import java.util.Objects;

public class IRISResponseModel implements Serializable {
    private String messageId;
    private String creationDateTime;
    private IRISResponse resp;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public IRISResponse getResp() {
        return resp;
    }

    public void setResp(IRISResponse resp) {
        this.resp = resp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IRISResponseModel that = (IRISResponseModel) o;
        return Objects.equals(messageId, that.messageId) && Objects.equals(creationDateTime, that.creationDateTime) && Objects.equals(resp, that.resp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, creationDateTime, resp);
    }

    @Override
    public String toString() {
        return "IRISResponseModel{" +
                "messageId='" + messageId + '\'' +
                ", creationDateTime='" + creationDateTime + '\'' +
                ", resp=" + resp +
                '}';
    }
}
