package com.zhonghuasheng.spring4.profileannotation.configuration;

import javax.sql.DataSource;

public interface DatabaseConfig {

    DataSource createDataSource();
}
