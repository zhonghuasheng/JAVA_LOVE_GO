package com.zhonghuasheng.spring4.profile;

import javax.sql.DataSource;

public interface DatabaseConfig {

    DataSource createDataSource();
}
