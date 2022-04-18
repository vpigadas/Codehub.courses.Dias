package com.dias.course.network.json;

import java.util.List;
import java.util.Objects;

public class JsonChannelResponse {

    private String channelName;
    private List<JsonShowResponse> shows;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<JsonShowResponse> getShows() {
        return shows;
    }

    public void setShows(List<JsonShowResponse> shows) {
        this.shows = shows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonChannelResponse that = (JsonChannelResponse) o;
        return Objects.equals(channelName, that.channelName) && Objects.equals(shows, that.shows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelName, shows);
    }

    @Override
    public String toString() {
        return "JsonChannelResponse{" +
                "channelName='" + channelName + '\'' +
                ", shows=" + shows +
                '}';
    }
}
