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

    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public void deleteCustomer(long id) {
        customerDAO.deleteCustomer(id);
    }
    public Customer findCustomerById(long id){
        return customerDAO.findCustomerById(id);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }
}
