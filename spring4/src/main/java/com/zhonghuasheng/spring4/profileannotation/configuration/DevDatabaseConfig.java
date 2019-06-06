package com.zhonghuasheng.spring4.profileannotation.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("dev")
@Configuration
public class DevDatabaseConfig implements DatabaseConfig {

    @Override
    @Bean
    public DataSource createDataSource() {
        System.out.println("Creating DEV database");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // DO WORK HERE dataSource.setDriverClassName("");
        return dataSource;
    }
}
