package com.zhonghuasheng.designpattern.reactor;

/**
 * Reactor服务启动类
 */
public class Server {

    public static void main(String[] args) throws InterruptedException {
        Selector selector = Selector.getInstance();
        Runnable dispatcher = new Dispatcher(selector);
        Runnable acceptor = new Acceptor(selector);
        new Thread(dispatcher).start();
        new Thread(acceptor).start();
        System.out.println("Started...");
    }
}
