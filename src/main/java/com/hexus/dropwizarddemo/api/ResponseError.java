package com.hexus.dropwizarddemo.api;

public class ResponseError {
    private String message;

    public ResponseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
