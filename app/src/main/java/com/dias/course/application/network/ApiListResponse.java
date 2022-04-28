package com.dias.course.application.network;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public interface ApiListResponse<T extends Serializable> {

    void onSuccess(List<T> dataList);

    void onFailed(Exception exception);
}
