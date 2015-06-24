package com.tw.core.service;

import com.tw.core.Customer;
import com.tw.core.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenbojian on 15-6-24.
 */
@Service
public class CustomerService {
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    public List<Customer> listCustomer(){
        return customerDAO.listCustomer();
    }
}
