package com.example.resttesttask2.exception;

import java.util.Date;

public class ErrorResponse {
    
    private String message;
    private Date timestamp;

    public ErrorResponse(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
