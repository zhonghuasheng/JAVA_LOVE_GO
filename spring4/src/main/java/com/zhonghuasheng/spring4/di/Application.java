package com.zhonghuasheng.spring4.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        /**
         * Spring IoC容器(ApplicationContext)负责创建Bean，并通过容器将功能类Bean注入到你需要的Bean中。
         * 这里传入的参数是DIConfig.class，表示的annotatedClass
         * DIConfig.class中通过@Configuration注解表示这是一个配置类bean，@ComponentScan注解将会自动扫描包
         * 名下所有使用@Service,@Component,@Repository和@Controller的类，并注册为Bean。
         */
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DIConfig.class);
        // 通过IOC容器来获取自己想要的bean
        UserFunctionService userFunctionService = appContext.getBean(UserFunctionService.class);
        userFunctionService.say("DI");
        appContext.close();
    }
}
