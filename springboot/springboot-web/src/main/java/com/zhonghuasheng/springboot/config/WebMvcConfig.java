package com.zhonghuasheng.springboot.config;

import com.zhonghuasheng.springboot.exception.CustomExceptionHandler;
import com.zhonghuasheng.springboot.interceptor.CustomHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomHandlerInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/templates/assets");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
    }

/*  推荐使用@ExceptionHandler来处理Controller层以内的异常
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(1, new CustomExceptionHandler()); // 帮助注入bean，也可以在自定义的Exception类上加@Component
    }
*/
// 这个bean是配合MyFilter使用，实现过滤器效果的。不建议使用，直接使用@WebFilter即可
    //@Bean
    /*public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("MyFilter1");
        registrationBean.setOrder(1);

        return registrationBean;
    }*/
}
