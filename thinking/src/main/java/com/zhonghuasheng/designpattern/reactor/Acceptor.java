package com.zhonghuasheng.designpattern.reactor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Reactor的事件接收类
 */
public class Acceptor implements Runnable {

    private int port;
    private Selector selector;
    // 通过inputSourceBlockingQueue来模拟外部输入请求队列
    private BlockingQueue<InputSource> inputSourceBlockingQueue = new LinkedBlockingQueue<InputSource>();

    public Acceptor(int port, Selector selector) {
        this.port = port;
        this.selector = selector;
    }

    // 外部有输入请求后，需要加入到请求队列中
    public void addConnection(InputSource source) {
        inputSourceBlockingQueue.offer(source);
    }

    public void run() {
        System.out.println("进入Acceptor: run");
        while (true) {
            InputSource source = null;
            try {
                source = inputSourceBlockingQueue.take();
                System.out.println("进入Acceptor: InputSource是" + source.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (source != null) {
                Event acceptEvent = new Event();
                acceptEvent.setSource(source);
                acceptEvent.setType(EventType.ACCEPT);
                selector.addEvent(acceptEvent);
            }
        }
    }

    public int getPort() {
        return this.port;
    }
}
