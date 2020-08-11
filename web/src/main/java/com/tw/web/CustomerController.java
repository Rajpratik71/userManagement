package com.tw.web;

import com.tw.core.Customer;
import com.tw.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listOfCustomer() {
        ModelAndView modelAndView = new ModelAndView("customerList");
        List<Customer> customers = customerService.listCustomer();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCustomerPage() {
        ModelAndView modelAndView = new ModelAndView("addCustomer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return new ModelAndView("redirect:/customer/");
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customer/");
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public ModelAndView editCustomerPage(@PathVariable("id") long id){
        ModelAndView modelAndView= new ModelAndView("customerEdit");
        Customer customer = customerService.findCustomerById(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @RequestMapping(value = "{id}/edit", method = RequestMethod.POST)
    public ModelAndView editCustomer(@PathVariable("id") long id,@ModelAttribute Customer customer){
        customerService.updateCustomer(customer);
        return new ModelAndView("redirect:/customer/");
    }
}
