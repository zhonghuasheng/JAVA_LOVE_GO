package com.zhonghuasheng.designpattern.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 事件轮询选择器类。模拟Reactor中的Demultiplexer类，提供select()方法用于从缓冲队列中查找出符合条件的event列表。
 */
public class Selector {

    // 用于实现缓冲队列，保证线程安全
    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();
    // 定义一个object用于synchronize方法块上锁
    private Object lock = new Object();

    public void addEvent(Event event) {
        boolean success = eventQueue.offer(event);
        if (success) {
            synchronized (lock) {
                lock.notify();
            }
        }
    }

    public List<Event> select() {
        return select(0);
    }

    // TODO 简单模拟将所有event全部返回，可增加业务逻辑将符合条件的event进行返回
    private List<Event> select(long timeout) {
        if (timeout > 0) {
            if (eventQueue.isEmpty()) {
                synchronized (lock) {
                    if (eventQueue.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        List<Event> events = new ArrayList<Event>();
        eventQueue.drainTo(events);

        return events;
    }
}
