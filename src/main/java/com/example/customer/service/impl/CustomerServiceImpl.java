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
        Customer customer = new Customer(record.id(), record.name(), record.city(), record.email());
        customerDao.save(customer);
        return true;
    }

    @Override
    public Boolean deleteCustomer(String id) {
        if (!customerDao.existsById(id)) throw new RuntimeException("Customer Not Found!");
        customerDao.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateCustomer(CustomerRecord record) {
        if (!customerDao.existsById(record.id())) throw new RuntimeException("Customer Not Found!");
        Customer customer = new Customer(record.id(), record.name(), record.city(), record.email());
        customerDao.updateCustomer(customer.getName(), customer.getCity(), customer.getEmail(), customer.getId());
        return true;
    }
}
