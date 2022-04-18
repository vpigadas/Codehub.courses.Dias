package com.dias.course.network.json;

import java.util.List;
import java.util.Objects;

public class JsonResponse {

    private List<JsonChannelResponse> channels;

    public List<JsonChannelResponse> getChannels() {
        return channels;
    }

    public void setChannels(List<JsonChannelResponse> channels) {
        this.channels = channels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponse that = (JsonResponse) o;
        return Objects.equals(channels, that.channels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channels);
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "channels=" + channels +
                '}';
    }
}
