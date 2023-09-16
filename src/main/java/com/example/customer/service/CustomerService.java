package com.example.customer.service;

import com.example.customer.dto.CustomerRecord;

public interface CustomerService {
    Boolean saveCustomer(CustomerRecord record);

    Boolean deleteCustomer(String id);

    Boolean updateCustomer(CustomerRecord record);

    CustomerRecord viewCustomer(String id);
}

