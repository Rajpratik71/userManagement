package com.tw.core.dao;

import com.tw.core.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenbojian on 15-6-24.
 */
@Repository
@Transactional
public class CustomerDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> listCustomer() {
        return sessionFactory.getCurrentSession().createQuery("from Customer")
                .list();
    }

    public void addCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    public void deleteCustomer(long id) {
        Customer customer = findCustomerById(id);
        if (customer != null) {
            sessionFactory.getCurrentSession().delete(customer);
        }
    }

    public Customer findCustomerById(long id) {
        Customer customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }
}
