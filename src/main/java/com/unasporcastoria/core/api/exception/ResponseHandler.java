package com.unasporcastoria.core.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {USSException.class})
    protected ResponseEntity<Object> handleConflict(
            USSException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getData(), new HttpHeaders(), ex.getError().getStatus(), request);
    }
}

