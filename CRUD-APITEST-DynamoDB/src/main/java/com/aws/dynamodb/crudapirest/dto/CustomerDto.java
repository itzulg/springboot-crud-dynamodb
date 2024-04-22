package com.aws.dynamodb.crudapirest.dto;


import java.util.List;

import com.aws.dynamodb.crudapirest.model.OrderItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    
    private String id;

    private String name;

    private String lastname;

    private String email;

    private int telephone;

    private String orderDate;

    private List<OrderItems> orderItemsDto;

}
