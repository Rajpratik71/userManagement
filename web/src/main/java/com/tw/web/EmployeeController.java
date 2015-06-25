package com.tw.web;

import com.tw.core.Employee;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by chenbojian on 15-6-23.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public ModelAndView listOfEmployee(){
        ModelAndView modelAndView = new ModelAndView("employeeList");
        List<Employee> employees = employeeService.listEmployee();
        int[] customerSize = new int[employees.size()];
        for(int i=0;i<customerSize.length;i++){
            customerSize[i]=employees.get(i).getPrivateCustomers().size();
        }
        modelAndView.addObject("employees",employees);
        modelAndView.addObject("customerSize",customerSize);

        return modelAndView;
    }

}
