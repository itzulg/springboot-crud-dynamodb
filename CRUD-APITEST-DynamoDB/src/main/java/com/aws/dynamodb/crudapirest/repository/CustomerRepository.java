package com.aws.dynamodb.crudapirest.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.dynamodb.crudapirest.model.Customer;

@EnableScan
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{

    boolean existsByName(String name);


}
