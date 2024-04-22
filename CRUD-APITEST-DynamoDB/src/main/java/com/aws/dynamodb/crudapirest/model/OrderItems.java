package com.aws.dynamodb.crudapirest.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class OrderItems {

    @DynamoDBAttribute
    private String productId;

    @DynamoDBAttribute
    private int quantity;

    @DynamoDBAttribute
    private double cost;

}
