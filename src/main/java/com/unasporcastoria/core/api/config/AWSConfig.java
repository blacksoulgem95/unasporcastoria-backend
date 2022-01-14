package com.unasporcastoria.core.api.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AWSConfig {
  @Value("${cloud.aws.access-key}")
  private String awsAccessKey;

  @Value("${cloud.aws.secret-key}")
  private String awsSecretKey;

  @Value("${cloud.aws.region}")
  private String region;

  @Value("${cloud.aws.s3.bucket}")
  private String bucket;

  @Primary
  @Bean
  public AmazonS3 amazonS3Client() {
    return AmazonS3ClientBuilder
        .standard()
        .withRegion(region)
        .withCredentials(new AWSStaticCredentialsProvider(
            new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
        .build();
  }

}
