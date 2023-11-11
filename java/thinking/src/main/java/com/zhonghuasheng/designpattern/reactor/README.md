* Reactor模式是事件驱动模型。整个Reactor模式解决的主要问题就是在接收到任务后根据分发器快速进行分发给相应的事件处理类，不需要从开始状态就阻塞。
    * Acceptor充当前端的接收器
    * Dispatcher将收到的Event按照类型进行转发处理
    * Selector是事件轮询选择器。Acceptor接受到数据后，将数据转换为Event格式，同时将Event放入Selector的EventQueue中；Dispatcher不断的轮询获取Selector中的EventQueue中的Event，将获取到的Event交给Handler来处理；Handler处理Event之后标注类型，同时将Event放回EventQueue;最后负责处理的Handler将Event从EventQueue中取出，并到放到FinishedEventQueue中。
    * Notifier负责轮询Selector中有没有处理完成的Event，然后将处理的结果返回给对应的Connector，这部分没有实现，只做简单说明

* 参考
    * [Reactor模式详解＋源码实现](https://www.jianshu.com/p/188ef8462100)