package com.unasporcastoria.core.api.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class FirebaseTokenInvalidException extends BadCredentialsException {

  private static final long serialVersionUID = 789949671713648425L;

  public FirebaseTokenInvalidException(String msg) {
    super(msg);
  }

  public FirebaseTokenInvalidException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
