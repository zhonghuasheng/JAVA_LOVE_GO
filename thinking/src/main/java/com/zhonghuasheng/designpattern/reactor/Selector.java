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
    private static BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();
    private static Selector selector = new Selector();
    private Selector() {}

    public static Selector getInstance() {
        System.out.println("eventQueue: " + eventQueue.toString());
        return selector;
    }

    public void addEvent(Event event) {
        boolean success = eventQueue.offer(event);
        System.out.println("Selector成功添加event " + event.getSource().toString());
        System.out.println("Selector类中当前eventQueue大小是： " + eventQueue.size());
    }

    // TODO 简单模拟将所有event全部返回，可增加业务逻辑将符合条件的event进行返回
    public static List<Event> select() throws InterruptedException {
        List<Event> events = new ArrayList<Event>();
        Event event = eventQueue.poll();
        if(event != null) {
            events.add(event);
        }

        return events;
    }
}
