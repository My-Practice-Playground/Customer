package com.example.customer.api;

import com.example.customer.dto.CustomerRecord;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    String saveCustomer(@RequestBody CustomerRecord customer) {
        if(customer == null || !customer.name().matches("[A-Za-z ]+")){
            throw new RuntimeException("Invalid name!");
        } else if (customer.email() == null) {
            throw new RuntimeException("Invalid email!");
        } else if (customer.city() == null) {
            throw new RuntimeException("Invalid city!");
        }
        customerService.saveCustomer(customer);
        return "Saved!";
    }


}
