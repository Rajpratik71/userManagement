package com.tw.core.test;

import com.tw.core.*;
import com.tw.core.dao.EmployeeDAO;
import com.tw.core.dao.UserDAO;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by chenbojian on 15-7-6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springTestReal.xml")
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class EmployeeDAOTest {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private UserDAO userDAO;

    @Test
    public void will_roll_back() {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, 1L);
        user.setName("hahaha");
        print_all();
    }

    private void print_all() {
        for (Employee employee : employeeDAO.listEmployee()) {
            System.out.println("" + employee + employee.getUser().getName());
        }
    }

    @Test
    public void should_delete_employee_only() {
//        System.out.println(sessionFactory.getCurrentSession().get(Employee.class,3L).getClass());
        Employee employee = employeeDAO.findEmployeeById(1);
        employeeDAO.deleteEmployee(employee.getId());
        assertThat(employeeDAO.findEmployeeById(employee.getId())).isNull();
        assertThat(userDAO.findUserById(employee.getUser().getId())).isNotNull();
    }

    @Test
    public void should_add_user_when_add_employee() {
        Employee employee = initEmployee("coach");
        userDAO.addUser(employee.getUser());
        employeeDAO.addEmployee(employee);
        print_all();
    }

    private Employee initEmployee(String job) {
        Employee employee;

        if (job.equalsIgnoreCase("HR")) {
            employee = new HumanResource();
        } else if (job.equalsIgnoreCase("OPs")) {
            employee = new Operations();
        } else {
            employee = new Coach();
        }

        User user = new User();
        user.setEmail("addemployee@add.add");
        user.setName("add employee");
        user.setAge(19);
        user.setPassword("password");
        employee.setUser(user);
//        user.setEmployee(employee);
        return employee;
    }

    @Test
    public void should_affect_user_when_update_employee() {
//        Employee employee = employeeDAO.findEmployeeById(1);
        Employee employee = initEmployee("coach");
        employee.setId(1);
        employee.getUser().setId(1);
        employee.getUser().setName("change by employee");
        employeeDAO.updateEmployee(employee);//here update can work on transient object
        sessionFactory.getCurrentSession().flush();
        print_all();
        assertThat(userDAO.findUserById(1).getName()).isEqualTo("change by employee");
    }

    @Test
    public void should_delete_user_when_delete_employee_because_of_cascade() {
        employeeDAO.deleteEmployee(1);
        assertThat(sessionFactory.getCurrentSession().get(User.class, 1L)).isNull();
    }


}
