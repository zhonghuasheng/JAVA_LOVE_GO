package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.config.PropertiesConfig;
import com.zhonghuasheng.springboot.config.UserConfig;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ConfigController {

    @Autowired
    PropertiesConfig propertiesConfig;

    @GetMapping("/property")
    public String getPropertiesConfig() {
        System.out.println(propertiesConfig.normal);
        System.out.println(propertiesConfig.osName);
        try {
            System.out.println(propertiesConfig.testUrl.getURL().toString());
            System.out.println(IOUtils.toString(propertiesConfig.testFile.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(propertiesConfig.randomNumber);


        return "success";
    }

    @Autowired
    UserConfig userConfig;

    @GetMapping("/user")
    public String getUserConfig() {
        System.out.println(userConfig.name);
        System.out.println(userConfig.age);
        System.out.println(userConfig.address);
        System.out.println(userConfig.desc);
        System.out.println(userConfig.uuid);
        System.out.println(userConfig.phone);
        System.out.println(userConfig.date);
        System.out.println(userConfig.hobby);
        System.out.println(userConfig.maps);

        return "success";
    }
}
