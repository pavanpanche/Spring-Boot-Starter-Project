package com.starter.springboot.dto;

public class ErrorResponse {
    private String error;
    private String message;

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }


    // Getters (essential for JSON serialization)
    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
