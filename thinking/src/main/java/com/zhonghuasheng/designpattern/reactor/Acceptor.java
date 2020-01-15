package com.zhonghuasheng.designpattern.reactor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Reactor的事件接收类
 */
public class Acceptor implements Runnable {

    private Selector selector;
    // 通过inputSourceBlockingQueue来模拟外部输入请求队列
    private static final BlockingQueue<InputSource> inputSourceBlockingQueue = new LinkedBlockingQueue<InputSource>();

    public Acceptor(Selector selector) {
        this.selector = selector;
        System.out.println("selector.hashCode(): " + selector.hashCode());
    }

    // 外部有输入请求后，需要加入到请求队列中
    public static void addConnection(InputSource source) {
        inputSourceBlockingQueue.offer(source);
        System.out.println("inputSourceBlockingQueue size: " + inputSourceBlockingQueue.size());
    }

    public void run() {
        System.out.println("进入Acceptor: run");
        while (true) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {

            }
            addConnection(new InputSource("Hello", 1));
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
                selector.addNewEvent(acceptEvent);
            }
        }
    }
}
