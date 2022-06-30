package org.learning.springbootTest.dto;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private final HttpStatus status;
    private final String reason;

    public ExceptionResponse(HttpStatus status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}
