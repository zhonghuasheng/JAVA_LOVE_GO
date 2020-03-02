package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.CustomerDao;
import com.ssm.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }
}
