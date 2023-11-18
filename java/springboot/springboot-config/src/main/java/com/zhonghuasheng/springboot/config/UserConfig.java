package com.zhonghuasheng.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class UserConfig {

    @Value("${user.name}") // 会被系统的user.name覆盖掉
    public String name;

    @Value("${user.age}")
    public int age;

    @Value("${user.address}")
    public String address;

    @Value("${user.desc}")
    public String desc;

    @Value("${user.uuid}")
    public String uuid;

    @Value("${user.phone: 13866666666}")
    public String phone;

    @Value("${user.date}")
    public Date date;

    @Value("#{'${user.hobbys}'.split(',')}")
    public List<String> hobby;

    @Value("#{${user.maps}}")
    public Map<String, String> maps;
}
