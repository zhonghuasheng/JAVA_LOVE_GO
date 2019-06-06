package com.zhonghuasheng.spring4.profileannotation.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("prod")
@Configuration
public class ProdDatabaseConfig implements DatabaseConfig {

    @Override
    @Bean
    public DataSource createDataSource() {
        System.out.println("Creating prod database");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // DO WORK HERE
        return dataSource;
    }
}
