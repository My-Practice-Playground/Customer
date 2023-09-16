package com.example.customer.service.impl;

import com.example.customer.dao.CustomerDao;
import com.example.customer.dto.CustomerRecord;
import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Boolean saveCustomer(CustomerRecord record) {
        Customer customer = new Customer();
        customer.setId(record.id());
        customer.setCity(record.city());
        customer.setName(record.name());
        customer.setEmail(record.email());
        customerDao.save(customer);

        return true;
    }
}
