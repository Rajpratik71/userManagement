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
    public CustomerDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> listCustomer(){
        return sessionFactory.getCurrentSession().createQuery("from Customer")
                .list();
    }

}
