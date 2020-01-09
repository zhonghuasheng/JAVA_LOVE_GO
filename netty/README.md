* sample package中是一个基础的Demo
* http package是[基于Netty实现一个简易的HTTP服务器](https://blog.csdn.net/wangshuang1631/article/details/73251180/)
    * HttpServer是浏览器中输入URL访问
    * NettyHttpServer是Netty客户端HttpClient访问，扩展支持浏览器访问也能接收处理
    * 注意：由于是浏览器访问，会默认有个http://localhost:8001/favicon.ico的请求
* websocket package是[基于Netty实现一个WebSocket服务,实现消息的主动推送](https://www.jianshu.com/p/56216d1052d7)
    * 在线测试http://coolaf.com/tool/chattest，测试url ws://localhost:8002/websocket
    * 扩展实现原程序功能，支持指定好友发送消息，在线测试时，发送数据格式如下
    ```json
    {"from": "2105d55c", "to":"2c67e59d","msg":"your message"}
    ```
    * 可扩展点：界面化/空闲监测/心跳监测

* 其他
    * 学习中发现一个现有框架，Netty-SocketIO是一个开源的、基于Netty的、Java版的即时消息推送项目。通过Netty-SocketIO，我们可以轻松的实现服务端主动向客户端推送消息的场景，比如说股票价格变化、K线图、消息提醒等。它和websocket有相同的作用，只不过Netty-SocketIO可支持所有的浏览器。
