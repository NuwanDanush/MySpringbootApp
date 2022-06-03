package com.example.mytest.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseDto<T> {
    private String message;
    private T object;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
