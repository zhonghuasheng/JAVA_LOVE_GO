package com.zhonghuasheng.springcloud.turbine;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.turbine.streaming.servlet.TurbineStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

@EnableTurbine
@EnableEurekaClient
@EnableHystrixDashboard
@SpringBootApplication
public class TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }

    //@Bean 不需要使用
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        TurbineStreamServlet turbineStreamServlet = new TurbineStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(turbineStreamServlet);
        registrationBean.setName("HystrixMetricsStreamServlet");
        registrationBean.addUrlMappings("/turbine.stream");
        registrationBean.setLoadOnStartup(1);

        return registrationBean;
    }
}
