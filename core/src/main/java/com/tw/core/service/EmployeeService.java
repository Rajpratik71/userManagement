package com.tw.core.service;

import com.tw.core.Employee;
import com.tw.core.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.DocFlavor;
import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Service
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public List<Employee> listEmployee() {
        return employeeDAO.listEmployee();
    }

    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Transactional
    public Employee findEmployeeById(long id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }

    @Transactional
    public void deleteEmployeeList(long[] ids) {
        employeeDAO.deleteEmployeeList(ids);
    }


}
