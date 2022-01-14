package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.config.auth.FirebaseTokenHolder;
import com.unasporcastoria.core.api.util.FirebaseParser;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {
  public FirebaseTokenHolder parseToken(String firebaseToken) {
    return new FirebaseParser().parseToken(firebaseToken);
  }
}