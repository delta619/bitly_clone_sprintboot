package com.delta619.bitly.clone.controller;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}