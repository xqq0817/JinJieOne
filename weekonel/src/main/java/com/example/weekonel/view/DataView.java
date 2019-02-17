package com.example.weekonel.view;

public interface DataView<T> {
    void success(T result);
    void defeated(T error);
}
