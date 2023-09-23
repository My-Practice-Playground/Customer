package com.example.customer.dao;

import com.example.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerDao extends JpaRepository<Customer, String> {
    Customer save(Customer customer);

    Customer getCustomerById(String id);

    @Transactional
    @Query("UPDATE Customer c SET c.name = :name, c.city = :city, c.email = :email WHERE    c.id = :id")
    int updateCustomer(@Param("name") String name, @Param("city") String city, @Param("email") String email, @Param("id") String id);
}