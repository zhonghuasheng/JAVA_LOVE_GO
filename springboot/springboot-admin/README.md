#### SpringBoot Admin
SpringBootAdmin用来管理和监控SpringBoot应用程序，它利用spring-boot-starter-actuator提供的功能，将各个微服务的状态整合到一起，并提供良好的界面查看支持，并且能够动态的修改实例日志级别。SpringBootAdmin分为server端和client端，server端可查看各个微服务的状态，client端将微服务注册到server端
> 主要的功能点有：
* 显示应用程序的监控状态
* 应用程序上下线监控
* 查看 JVM，线程信息
* 可视化的查看日志以及下载日志文件
* 动态切换日志级别
* Http 请求信息跟踪
* 其他功能点……

##### `项目说明`
1. SpringBoot Admin需要引入`spring-boot-admin-starter-server`，客户端引入`spring-boot-admin-starter-client`；服务端启动函数加@EnableAminServer，客户端不需要
2. Admin界面的地址`http://localhost:9090`，client端需要在配置文件中指定`spring.boot.admin.client.url`的值指向Admin的地址
3. 我在springboot-log4j2项目中也添加了amdmin-client，项目启动后可以在dashboard上查看应用状态
4. TODO 可继续集成SpringBoot Security，SpringBoot Mail
5. TODO SpringCloud Nacos集成SpringBoot Admin https://blog.csdn.net/qq_38496561/article/details/105945386
只需要在Nacos中做一些集成，其他的微服务只需要引入actuator健康检查