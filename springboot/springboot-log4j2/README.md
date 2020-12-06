### 示例介绍
> 这个demo是springboot集成log4j2，具有以下功能：
* 可以做到按应用名建立文件夹，分门别类的统计日记。具体可以看log4j2的lookup【springcloud的集成好像可以直接读spring.application.name这个值，不需要额外set】，主要是通过log4j2来读取配置的变量实现，可以看main函数中的代码。
* 按文件大小或者按天来rolling日志文件
* 使用log4j2异步日志，异步日志包括AsyncAppender和AsyncLogger，两者对LogEvent的处理方式不同
* 增加日志的格式化模式，比如前缀，这样的话可以方便后期集成到ELK中

### 笔记
* 我对java中log的总结汇总： https://github.com/zhonghuasheng/Tutorial/blob/master/plugins/log.md