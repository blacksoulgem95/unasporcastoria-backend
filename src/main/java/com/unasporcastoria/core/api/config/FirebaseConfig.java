package com.unasporcastoria.core.api.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
@Configuration
public class FirebaseConfig {
  @Value("${cloud.firebase.serviceaccount}")
  private String serviceAccount;

  @Value("${cloud.firebase.bucket}")
  private String bucket;

  @Value("${debug}")
  private boolean debug;

  {
    log.info("Loading {}", this.getClass().getCanonicalName());
  }

  @Bean
  public FirebaseOptions options() throws IOException {
    if (debug)
      log.info("Starting Firebase Initialization - getting Service Account: {}", serviceAccount);

    return FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(new ByteArrayInputStream(serviceAccount.getBytes(StandardCharsets.UTF_8))))
        .build();
  }

  @Bean
  public FirebaseApp firebaseApp() throws IOException {
    return FirebaseApp.initializeApp(options());
  }

  @Bean
  public FirebaseAuth firebaseAuth() throws IOException {
    return FirebaseAuth.getInstance(firebaseApp());
  }

  @Bean
  public Firestore firestore() {
    try {
      return FirestoreClient.getFirestore(firebaseApp());
    } catch (Exception e) {
      log.warn("Cannot instantiate Firestore:", e);
      return null;
    }
  }

  @Bean
  public Bucket bucket() {
    try {
      return StorageClient.getInstance(firebaseApp()).bucket(bucket);
    } catch (Exception e) {
      log.warn("Cannot instantiate Google Cloud Bucket:", e);
      return null;
    }
  }
}
