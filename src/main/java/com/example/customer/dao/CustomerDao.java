package com.example.customer.dao;

import com.example.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer,String> {
    Customer save(Customer customer);
    Optional<Customer> findById(String id);
}
