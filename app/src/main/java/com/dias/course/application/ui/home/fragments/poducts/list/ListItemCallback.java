package com.dias.course.application.ui.home.fragments.poducts.list;

import java.io.Serializable;

public interface ListItemCallback<T extends Serializable> {

    void onClick(T data);
}
