package com.tw.core.test;

import com.tw.core.Coach;
import com.tw.core.Employee;
import com.tw.core.HumanResource;
import com.tw.core.User;
import com.tw.core.dao.UserDAO;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by chenbojian on 15-7-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springTestReal.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private SessionFactory sessionFactory;


    @Test
    public void first() {
        assertEquals(1, 1);
    }

    @Transactional
    @Rollback
    @Test
    public void show_dabase_change() {
        User user = new User();
//        user.setId(1);
        user.setName("change");
        user.setEmail("email@email.com");
        user.setPassword("password");
        Coach coach = new Coach();
        user.setEmployee(coach);
        coach.setUser(user);
        userDAO.addUser(user);
//        userDAO.saveOrUpdate(user);
        print_all();
        assertEquals(1, 1);
    }

    @Transactional
    @Rollback
    @Test
    public void should_add_user_without_employee_correctly() {
        User user = initUser();
        int userSize = userDAO.listUser().size();
        userDAO.addUser(user);
        assertEquals(userSize + 1, userDAO.listUser().size());
    }

    @Transactional
    @Rollback
    @Test
    public void should_add_user_with_HR_correctly() {
        User user = initUser();
        user.setEmployee(new HumanResource());
        user.getEmployee().setUser(user);

        int userSize = userDAO.listUser().size();
        userDAO.addUser(user);
        assertEquals(userSize + 1, userDAO.listUser().size());

        assertEquals(user.getEmployee().getId() != 0, true);
    }

    @Transactional
    @Rollback
    @Test
    public void should_add_user_with_coach_correctly() {
        User user = initUser();
        user.setEmployee(new Coach());
        user.getEmployee().setUser(user);

        int userSize = userDAO.listUser().size();
        userDAO.addUser(user);
        assertEquals(userSize + 1, userDAO.listUser().size());

        assertEquals(user.getEmployee().getId() != 0, true);
    }

    @Transactional
    @Rollback
    @Test
    public void should_edit_user_correct() {
        User user = userDAO.findUserById(1);
        user.setName("create_for_test");
        userDAO.updateUser(user);
        assertEquals(userDAO.findUserByName("create_for_test").size() == 1, true);

    }

    @Transactional
    @Rollback
    @Test
    public void orphanRemoval_work_when_disconnect_association() {
        User user = userDAO.findUserById(1);
        user.setName("create_for_test");
        user.getEmployee().setUser(null);
        user.setEmployee(null);
        userDAO.updateUser(user);
        List<Employee> employees = (List<Employee>) sessionFactory.getCurrentSession().createQuery("from Employee where USER_ID = 1").list();
//        System.out.println("" + employee.getId());
        assertEquals(employees.size(), 0);
        //        print_all();
    }

    @Transactional
    private void print_all() {
        List<User> users = userDAO.listUser();
        System.out.println("----------------------------------------------");
        for (User user : users) {
            System.out.println(user.getName() + "---" + user.getId() + "---" + user.getEmployee());
        }
        System.out.println("----------------------------------------------");
        for (Employee employee : (List<Employee>) sessionFactory.getCurrentSession().createQuery("from Employee").list()) {
            System.out.println("" + employee.getId() + employee);
        }
    }

    private User initUser() {
        User user = new User();
        user.setName("add_user");
        user.setEmail("email@email.com");
        user.setPassword("password");
        user.setAge(18);
        return user;
    }
}
