### 自定义spring boot starter
1. 自定义starter的命名规则
* SpringBoot提供的starter以spring-boot-starter-xxx的方式命名的。官方建议自定义的starter使用xxx-spring-boot-starter命名规则。以区分SpringBoot生态提供的starter。
2. 新建一个工程，pom中引入必要的依赖
3. 定义一个配置类，使用@Configuration注解
4. 在resource文件夹下新建WEN-INF文件夹，并添加spring.factories文件，同时加如下配置信息
`org.springframework.boot.autoconfigure.EnableAutoConfiguration=配置类的详细路径`
5. 执行 `mvn clean install`，这样其他project就可以引用本地的dependency了
6. 在其他项目中可以直接使用了