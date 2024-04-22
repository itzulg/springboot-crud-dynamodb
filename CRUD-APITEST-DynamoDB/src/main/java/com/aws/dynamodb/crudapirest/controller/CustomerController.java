package com.aws.dynamodb.crudapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.aws.dynamodb.crudapirest.dto.CustomerDto;
import com.aws.dynamodb.crudapirest.model.Customer;
import com.aws.dynamodb.crudapirest.service.CustomerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping("/customer")
    public ResponseEntity<Iterable<Customer>> customerList(){
        return ResponseEntity.ok(service.getCustomerList());
    }
    
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> customerById(@PathVariable("customerId") String customerId) {
        if (!service.existsId(customerId)) {
            return new ResponseEntity("Id Inexistente", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(service.getCustomer(customerId));
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCostumer(@RequestBody CustomerDto customerDto) {
        if (service.existsId(customerDto.getId())) {
            return new ResponseEntity("The id already exists",HttpStatus.BAD_REQUEST);
        }
        service.saveCustomer(customerDto);
        return new ResponseEntity("Created customer", HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity<?> updateCostumer(@RequestBody CustomerDto customerDto) {
        if (!service.existsId(customerDto.getId())) {
            return new ResponseEntity("The id does not exist",HttpStatus.NOT_FOUND);
        }
        service.updateCustomer(customerDto);
        return new ResponseEntity("Updated customer", HttpStatus.OK);
    }
   
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<?> deleteById(@PathVariable("customerId") String customerId) {
        if (!service.existsId(customerId)) {
            return new ResponseEntity("The id does not exist", HttpStatus.NOT_FOUND);
        }
        service.deleteCustomer(customerId);
        return new ResponseEntity("Deleted customer", HttpStatus.OK);
    }


}
