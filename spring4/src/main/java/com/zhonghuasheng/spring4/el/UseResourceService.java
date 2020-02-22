package com.zhonghuasheng.spring4.el;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UseResourceService {

    // 普通字符串
    @Value("Hello")
    private String normal;

    // 操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    // 表达式结果
    @Value("#{T(java.lang.Math).random() * 100}")
    private double randomNumber;

    // 其他bean的属性
    @Value("#{userService.property}")
    private String fromUserService;

    // 文件资源
    @Value("classpath:el-test.txt")
    private Resource testFile;

    // 网络资源
    @Value("http://www.baidu.com")
    private Resource baiduHtml;

    // 配置文件
    @Value("${u.name}")
    private String author;

    // 配置文件
    @Autowired
    private Environment environment;

    public void printResource() throws IOException {
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(randomNumber);
        System.out.println(fromUserService);
        System.out.println(IOUtils.toString(testFile.getInputStream(), "UTF-8"));
        System.out.println(IOUtils.toString(baiduHtml.getInputStream(), "UTF-8"));
        System.err.println(author);
        System.out.println(environment.getProperty("u.age"));
        System.out.println(environment.getProperty("u.name"));
    }
}
