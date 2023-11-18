package com.zhonghuasheng.spring4.profile;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DevDatabaseConfig implements DatabaseConfig {

    @Override
    public DataSource createDataSource() {
        System.out.println("Creating DEV database");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Init database here
        return dataSource;
    }
}
