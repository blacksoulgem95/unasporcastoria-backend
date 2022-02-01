package com.unasporcastoria.core.api.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.unasporcastoria.core.api.config.auth.FirebaseTokenHolder;
import com.unasporcastoria.core.api.exception.FirebaseTokenInvalidException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirebaseParser {

  private final FirebaseAuth firebaseAuth;

  public FirebaseTokenHolder parseToken(String idToken) {
    if (StringUtils.isBlank(idToken)) {
      throw new IllegalArgumentException("FirebaseTokenBlank");
    }
    try {
      FirebaseToken token = firebaseAuth.verifyIdToken(idToken);


      return new FirebaseTokenHolder(token);
    } catch (Exception e) {
      throw new FirebaseTokenInvalidException(e.getMessage());
    }
  }
}