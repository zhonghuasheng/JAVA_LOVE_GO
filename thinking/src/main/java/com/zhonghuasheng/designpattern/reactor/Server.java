package com.zhonghuasheng.designpattern.reactor;

/**
 * Reactor服务启动类
 */
public class Server {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started...");
        Selector selector = new Selector();
        Acceptor acceptor = new Acceptor(1234, selector);
        Dispatcher dispatcher = new Dispatcher(selector);
        Thread thread = new Thread(acceptor);
        thread.start();
        dispatcher.handleEvents();
        Thread.sleep(2000);
        dispatcher.registerEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        dispatcher.registerEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
    }
}
