package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.City;
import com.ssm.service.CityService;

@Controller
public class CityController {

    @Resource
    private CityService cityService;

    @RequestMapping("/city")
    public ModelAndView getCities() {
        ModelAndView mav = new ModelAndView("city/list");
        List<City> cities = cityService.getCities();
        mav.addObject("cities", cities);

        return mav;
    }
}