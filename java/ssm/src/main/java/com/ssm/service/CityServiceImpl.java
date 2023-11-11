package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.CityDao;
import com.ssm.model.City;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> getCities() {
        return cityDao.getCities();
    }

}
