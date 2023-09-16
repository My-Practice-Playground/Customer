package com.example.customer.api;

import com.example.customer.dto.CustomerRecord;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    String saveCustomer(@RequestBody CustomerRecord record) {
        if (validate(record)) customerService.saveCustomer(record);
        return "Saved!";
    }

    private boolean validate(CustomerRecord record) {
        if (record == null || !record.name().matches("[A-Za-z0-9]+")) {
            throw new RuntimeException("Invalid name!");
        } else if (record.email() == null) {
            throw new RuntimeException("Invalid email!");
        } else if (record.city() == null) {
            throw new RuntimeException("Invalid city!");
        }
        return true;
    }

    @DeleteMapping(params = "id")
    private boolean deleteCustomer(String id) {
        if (!id.matches("[A-Za-z0-9]+")) throw new RuntimeException("Invalid customer id!");
        customerService.deleteCustomer(id);
        return true;
    }

    @PutMapping
    private String updateCustomer(@RequestBody CustomerRecord record) {
        if (!validate(record)) return "Invalid customer details!";
        customerService.updateCustomer(record);
        return "Customer updated successfully";
    }


    @GetMapping(params = "id")
    private String viewCustomer(String id) {
        System.out.println(id);
        if (!id.matches("[A-Za-z0-9]+")) throw new RuntimeException("Invalid customer id!");
        CustomerRecord customerRecord = customerService.viewCustomer(id);
        return customerRecord.toString();
    }


}
