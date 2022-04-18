package com.dias.course.network.json;

import java.util.Objects;

public class JsonShowResponse {
    private long endTime;
    private String title;
    private long startTime;
    private String endTimeCaption;
    private String startTimeCaption;

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getEndTimeCaption() {
        return endTimeCaption;
    }

    public void setEndTimeCaption(String endTimeCaption) {
        this.endTimeCaption = endTimeCaption;
    }

    public String getStartTimeCaption() {
        return startTimeCaption;
    }

    public void setStartTimeCaption(String startTimeCaption) {
        this.startTimeCaption = startTimeCaption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonShowResponse that = (JsonShowResponse) o;
        return endTime == that.endTime && startTime == that.startTime && Objects.equals(title, that.title) && Objects.equals(endTimeCaption, that.endTimeCaption) && Objects.equals(startTimeCaption, that.startTimeCaption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endTime, title, startTime, endTimeCaption, startTimeCaption);
    }

    @Override
    public String toString() {
        return "JsonShowResponse{" +
                "endTime=" + endTime +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTimeCaption='" + endTimeCaption + '\'' +
                ", startTimeCaption='" + startTimeCaption + '\'' +
                '}';
    }
}
