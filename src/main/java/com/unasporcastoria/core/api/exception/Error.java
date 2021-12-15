package com.unasporcastoria.core.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {
    NOT_FOUND("NOT_FOUND", HttpStatus.NOT_FOUND, "Entity {0} was not found."),
    WRONG_FILE_TYPE("WRONG_FILE_TYPE", HttpStatus.BAD_REQUEST, "We require {0} file types, you uploaded an incompatible file of type {1}"),
    FILE_UPLOAD_ERROR("FILE_UPLOAD_ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "Cannot upload file"),
    ;

    private final String code;
    private final HttpStatus status;
    private final String messageFormat;

    Error(String code, HttpStatus status, String messageFormat) {
        this.code = code;
        this.status = status;
        this.messageFormat = messageFormat;
    }
}
