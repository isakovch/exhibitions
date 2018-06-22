package com.urancompany.exhibitions.ui;

public interface ILifecycle<V> {

    void bind(V view);

    void unbind();

}
