package com.zhonghuasheng.spring4.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void print() {
        System.out.println("BeanName is " + beanName);
        Resource resource = resourceLoader.getResource("classpath:el-test.txt");
        try {
            System.out.println(IOUtils.toString(resource.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
