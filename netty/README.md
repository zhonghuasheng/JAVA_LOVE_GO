* sample package中是一个基础的Demo
* http package是[基于Netty实现一个简易的HTTP服务器](https://blog.csdn.net/wangshuang1631/article/details/73251180/)
    * HttpServer是浏览器中输入URL访问
    * NettyHttpServer是Netty客户端HttpClient访问，扩展支持浏览器访问也能接收处理
    * 注意：由于是浏览器访问，会默认有个http://localhost:8001/favicon.ico的请求
* websocket package是基于Netty实现一个WebSocket服务
    * 在线测试http://coolaf.com/tool/chattest，测gi试url ws://localhost:8002/websocket
    * 扩展实现原程序功能，支持指定好友发送消息，在线测试时，发送数据格式如下
    ```json
    {"from": "2105d55c", "to":"2c67e59d","msg":"your message"}
    ```