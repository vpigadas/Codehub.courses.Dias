package com.dias.course.application.utils;

import java.io.Serializable;

public interface ListItemCallback<T extends Serializable> {

    void onClick(T data);
}
