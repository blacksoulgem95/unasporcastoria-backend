package com.unasporcastoria.core.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class USSException extends RuntimeException {
    @Getter
    private final Error error;

    public USSException(Error error, String message) {
        super(error.getCode() + " - " + message);
        this.error = error;
    }

    public USSException(Error error, String message, Exception ex) {
        super(error.getCode() + " - " + message, ex);
        this.error = error;
    }

    public ErrorData getData() {
        return new ErrorData(error.getCode(), this.getMessage());
    }

    @Data
    @AllArgsConstructor
    public static class ErrorData {
        private final String errorCode;
        private final String message;
    }
}
