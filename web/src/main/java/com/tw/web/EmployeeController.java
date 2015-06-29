package com.tw.web;

import com.tw.core.Customer;
import com.tw.core.Employee;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

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
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addEmployeePage(){
        ModelAndView modelAndView = new ModelAndView("addEmployee");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return new ModelAndView("redirect:/employee/");
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.GET)
    public ModelAndView editEmployeePage(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView("employeeEdit");
        Employee employee = employeeService.findEmployeeById(id);
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.POST)
    public ModelAndView editEmployee(@PathVariable("id") long id,
                                     @ModelAttribute Employee employee){
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:/employee/");
    }

    @RequestMapping("/{id}/delete")
    public ModelAndView deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/employee/");
    }
}
