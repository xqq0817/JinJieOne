package com.example.weekonel.utils;

public interface UtilsCallBack<T> {
    void success(T result);
    void defeated(T error);
}
