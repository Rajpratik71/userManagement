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
@Transactional
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> listEmployee() {
        return employeeDAO.listEmployee();
    }

    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    public Employee findEmployeeById(long id) {
        return employeeDAO.findEmployeeById(id);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }

    public void deleteEmployeeList(long[] ids) {
        employeeDAO.deleteEmployeeList(ids);
    }


}
