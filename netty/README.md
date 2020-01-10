## Netty实战
* `sample` Netty的Hello World例子，作为Netty的入门
* `http` 基于Netty实现的一个简易版本的HTTP服务器，对于学习HTTP服务器底层原理还是很有帮助。参考文章[基于Netty实现一个简易的HTTP服务器](https://blog.csdn.net/wangshuang1631/article/details/73251180/)
    * 说明
        * HttpServer是浏览器中输入URL访问
        * NettyHttpServer是Netty客户端HttpClient访问，扩展支持浏览器访问也能接收处理
        * 注意：由于是浏览器访问，会默认有个http://localhost:8001/favicon.ico的请求
* `websocket` 基于Netty实现一个简易版本的WebSocket服务，并实现消息的主动推送。参考文章[基于Netty实现一个WebSocket服务,实现消息的主动推送](https://www.jianshu.com/p/56216d1052d7)
    * 说明
        * websocket在线测试http://coolaf.com/tool/chattest，测试url ws://localhost:8002/websocket
        * 扩展实现原程序功能，支持指定好友发送消息。目前只支持JSON字符串格式的数据，并且key必须hard code，在线测试时，发送数据格式如下
        ```json
        {"from": "2105d55c", "to":"2c67e59d","msg":"your message"}
        ```
        * 可扩展点：界面化/空闲监测/心跳监测
* `tcp` 基于Netty实现自定义TCP数据格式的数据发送。参考文章[netty_TCP](https://github.com/Siwash/netty_TCP)
    * 说明
        * 数据格式是自定义的
        * 这个例子可以帮助学习理解TCP/UDP/Socket的工作原理
* `udp` 基于Netty实现一个简单的UDP。
    * 说明
        * UDP不需要绑定IP，只需要关注端口。这里可以补一下TCP和UDP的区别。

## 可扩展
* 在Music Store项目中加入聊天功能

## 其他
* 学习中发现一个现有框架，Netty-SocketIO是一个开源的、基于Netty的、Java版的即时消息推送项目。通过Netty-SocketIO，我们可以轻松的实现服务端主动向客户端推送消息的场景，比如说股票价格变化、K线图、消息提醒等。它和websocket有相同的作用，只不过Netty-SocketIO可支持所有的浏览器。

