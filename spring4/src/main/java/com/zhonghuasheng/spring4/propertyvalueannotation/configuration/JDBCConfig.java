package com.zhonghuasheng.spring4.propertyvalueannotation.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("jdbcConfig")
public class JDBCConfig {

    @Value("${jdbc.host}")
    private String host;
    @Value("${jdbc.port}")
    private int port;
    @Value("${jdbc.database}")
    private String database;
    @Value("${jdbc.user:test}")
    private String user;
    @Value("${jdbc.password:123456}")
    private String password;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "JDBCConfig [host=" + host + ", port=" + port + ", database="
                + database + ", user=" + user + ", password=" + password + "]";
    }
}
