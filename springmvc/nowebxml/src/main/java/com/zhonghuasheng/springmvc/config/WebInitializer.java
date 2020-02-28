package com.zhonghuasheng.springmvc.config;

import com.zhonghuasheng.springmvc.config.MvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    /**
     * 添加WebInitializer文件，实现WebApplicationInitializer类，
     * 这一步是实现无web.xml方式启动web项目的关键，
     * 容器会通过ServletContainerInitializer回调SpringServletContainerInitializer，
     * 再加载调用WebApplicationInitializer的onStartup的方法，从而启动spring容器
     * @param servletContext
     * @throws ServletException
     */
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(MvcConfig.class);
        appContext.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
