package com.zhonghuasheng.spring4.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Profile("dev")
    @Bean
    public DataSource devDataSource() {
        return new DevDatabaseConfig().createDataSource();
    }

    @Profile("prod")
    @Bean
    public DataSource prodDataSource() {
        return new ProdDatabaseConfig().createDataSource();
    }
}
