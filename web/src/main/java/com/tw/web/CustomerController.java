package com.tw.web;

import com.tw.core.Customer;
import com.tw.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by chenbojian on 15-6-24.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView listOfCustomer(){
        ModelAndView modelAndView = new ModelAndView("customerList");
        List<Customer> customers = customerService.listCustomer();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
}
