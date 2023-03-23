package com.music.musicwebsitebackend.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import org.apache.http.auth.Credentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 *  Amazon S3 config.
 * */
@Configuration
public class AmazonS3Config {

    @Value("${awsAccessKey}")
    private String accesskey;

    @Value("${awsSecurityKey}")
    private String secretKey;

    public AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials(
                accesskey,
                secretKey
        );

        return credentials;
    }

    @Bean
    public AmazonS3 amazonS3() {
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withRegion(Regions.US_EAST_2)
                .build();
        return s3client;
    }

}
