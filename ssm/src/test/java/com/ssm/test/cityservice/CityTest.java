package com.ssm.test.cityservice;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.model.City;
import com.ssm.service.CityService;
import com.ssm.test.base.SpringTestCase;

public class CityTest extends SpringTestCase {
    @Autowired
    private CityService cityService;

    @Test
    public void testGetCities() {
        List<City> cities = cityService.getCities();
        int length = cities.size();

        for (int i = 0; i < length; i++) {
            System.out.println(cities.get(i).getClassName());
        }
    }
}
