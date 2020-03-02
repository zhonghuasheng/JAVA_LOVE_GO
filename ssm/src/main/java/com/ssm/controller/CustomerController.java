package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.Customer;
import com.ssm.service.CustomerService;

@Controller
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("/customer/list")
    public ModelAndView getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);

        return modelAndView;
    }
}
