package com.springBatch.Customer_SpringBatch.config;

import com.springBatch.Customer_SpringBatch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
        if(customer.getCountry().equals("Netherlands")) {
            return customer;
        }else{
            return null;
        }
    }
}
