package com.springBatch.Customer_SpringBatch.repository;

import com.springBatch.Customer_SpringBatch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}
