package com.unasporcastoria.core.api.exception;

import lombok.Getter;

import java.text.MessageFormat;

public class NotFoundException extends USSException {
    @Getter
    private final String entity;

    public NotFoundException(String entity) {
        super(Error.NOT_FOUND, MessageFormat.format(Error.NOT_FOUND.getMessageFormat(), entity));
        this.entity = entity;
    }
}
