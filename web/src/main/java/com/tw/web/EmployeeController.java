package com.tw.web;

import com.tw.core.Employee;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//import javax.servlet.jsp.jstl.core.Config;

/**
 * Created by chenbojian on 15-6-23.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(){
        return "error";
    }
    @RequestMapping("/")
    public ModelAndView listOfEmployee() {
        ModelAndView modelAndView = new ModelAndView("employeeList");
        List<Employee> employees = employeeService.listEmployee();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addEmployeePage() {
        ModelAndView modelAndView = new ModelAndView("addEmployee");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @RequestMapping("/{id}/delete")
    public ModelAndView deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/employee/");
    }
}
