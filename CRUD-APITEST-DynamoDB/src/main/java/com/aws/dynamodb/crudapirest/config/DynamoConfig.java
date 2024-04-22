package com.aws.dynamodb.crudapirest.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.aws.dynamodb.crudapirest.repository")
public class DynamoConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String endpoint;

    @Value("${amazon.aws.acceskey}")
    private String accesKey;

    @Value("${amazon.aws.secretkey}")
    private String secretKey;

    @Value("${amazon.aws.region}")
    private String region;

    @Bean
    public AmazonDynamoDB amazonDynamoDB (){
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
        .withCredentials(awsCredentialsProvider()).build();

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider(){
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesKey, secretKey));
    }

}
