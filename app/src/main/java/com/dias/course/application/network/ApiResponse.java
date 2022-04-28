package com.dias.course.application.network;

import java.io.Serializable;
import java.util.Objects;

public interface ApiResponse<T extends Serializable> {

    void onSuccess(T data);

    void onFailed(Exception exception);
}