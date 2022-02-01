package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.config.auth.FirebaseTokenHolder;
import com.unasporcastoria.core.api.util.FirebaseParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirebaseService {

  private final FirebaseParser firebaseParser;

  public FirebaseTokenHolder parseToken(String firebaseToken) {
    return firebaseParser.parseToken(firebaseToken);
  }
}