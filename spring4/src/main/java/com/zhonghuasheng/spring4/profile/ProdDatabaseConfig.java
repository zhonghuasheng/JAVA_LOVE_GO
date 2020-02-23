package com.zhonghuasheng.spring4.profile;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class ProdDatabaseConfig implements DatabaseConfig {

    @Override
    public DataSource createDataSource() {
        System.out.println("Creating prod database");
        return (DataSource) new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.valueOf("mysql"))
                .addScript("classpath:xxx.sql")
                .addScript("classpath:xxx.sql")
                .build();
    }
}
