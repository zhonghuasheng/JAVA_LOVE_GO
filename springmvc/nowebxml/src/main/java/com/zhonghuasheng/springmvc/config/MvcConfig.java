package com.zhonghuasheng.springmvc.config;

import com.zhonghuasheng.springmvc.interceptor.TimeCostInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zhonghuasheng.springmvc")
public class MvcConfig extends WebMvcConfigurerAdapter {

    // 视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/"); // 指定页面位置，该位置为编译后的位置，参考SpringBoot
        viewResolver.setSuffix(".jsp"); // 指定页面后缀
        viewResolver.setViewClass(JstlView.class); // 指定解析视图的类

        return viewResolver;
    }

    // 静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    // 注册拦截器
    @Bean
    public TimeCostInterceptor timeCostInterceptor() {
        return new TimeCostInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeCostInterceptor());
    }

    // 对于只是简单页面跳转不涉及业务的Controller，可以通过ViewController来配置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 不使用后缀匹配，可以访问类似xxx.do这样的url
        configurer.setUseSuffixPatternMatch(false);
        // configurer.setPathMatcher(PathMatcher) 自定义URL匹配
    }

    // 文件上传
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSizePerFile(1024 * 1024); // 单个文件大小1M

        return multipartResolver;
    }
}
