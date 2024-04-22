package com.aws.dynamodb.crudapirest.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.dynamodb.crudapirest.dto.CustomerDto;
import com.aws.dynamodb.crudapirest.model.Customer;
import com.aws.dynamodb.crudapirest.model.OrderItems;
import com.aws.dynamodb.crudapirest.repository.CustomerRepository;
@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository repository;
    

    List<OrderItems> listaOrder = new ArrayList<>();
    

    public Iterable<Customer> getCustomerList(){
        return repository.findAll();
    }

    public Customer getCustomer(String customerId){
        return repository.findById(customerId).get();
    }

    public Customer saveCustomer(CustomerDto customerDto){
        Customer customer = Customer.builder()
                .customerId(customerDto.getId())
                .name(customerDto.getName())
                .lastname(customerDto.getLastname())
                .email(customerDto.getEmail())
                .telephone(customerDto.getTelephone())
                .orderDate(customerDto.getOrderDate())
                .build();

                customerDto.getOrderItemsDto().stream().forEach(c -> listaOrder.add(c) );
                customer.setOrderItems(listaOrder);
            
        return repository.save(customer);
    }

    public Customer updateCustomer(CustomerDto customerDto){
        Customer customer = repository.findById(customerDto.getId()).get();
        customer.setCustomerId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setLastname(customerDto.getLastname());
        customer.setEmail(customerDto.getEmail());
        customer.setOrderDate(customerDto.getOrderDate());
        customer.setTelephone(customerDto.getTelephone());

        listaOrder.removeAll(listaOrder);

        customerDto.getOrderItemsDto().stream().forEach(c -> { 
            listaOrder.add(c);
        });
                
        customer.setOrderItems(listaOrder);

        return repository.save(customer);
    }

    public void deleteCustomer(String customerId){
        repository.deleteById(customerId);
    }

    public boolean existsId(String customerId){
        return repository.existsById(customerId);
    }

    public boolean existsByName(String name){
        return repository.existsByName(name);
    }

}
