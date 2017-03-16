package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.ssm.dao.CompanyDao;
import com.ssm.domain.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public Company getUserById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
