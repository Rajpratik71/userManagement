package com.tw.core.dao;

import com.tw.core.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Repository
@Transactional(readOnly = true)
public class EmployeeDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Employee> listEmployee() {
        return sessionFactory.getCurrentSession().createQuery("from Employee")
                .list();
    }

    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    public Employee findEmployeeById(long id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
        return employee;
    }

    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    public void deleteEmployee(long id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            sessionFactory.getCurrentSession().delete(employee);
        }
    }

    public void deleteEmployeeList(long[] ids) {
        for (long id : ids) {
            deleteEmployee(id);
        }
    }

}
