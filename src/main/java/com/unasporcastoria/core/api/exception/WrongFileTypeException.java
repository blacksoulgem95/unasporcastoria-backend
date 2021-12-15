package com.unasporcastoria.core.api.exception;

import java.text.MessageFormat;

public class WrongFileTypeException extends USSException {

    public WrongFileTypeException(String acceptedType, String providedType) {
        super(Error.WRONG_FILE_TYPE, MessageFormat.format(Error.WRONG_FILE_TYPE.getMessageFormat(), acceptedType, providedType));
    }

}
