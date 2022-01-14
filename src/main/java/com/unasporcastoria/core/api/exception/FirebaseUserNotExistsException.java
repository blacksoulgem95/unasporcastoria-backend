package com.unasporcastoria.core.api.exception;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

public class FirebaseUserNotExistsException extends AuthenticationCredentialsNotFoundException {

  private static final long serialVersionUID = 789949671713648425L;

  public FirebaseUserNotExistsException() {
    super("User Not Found");
  }
}
