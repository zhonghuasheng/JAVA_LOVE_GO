package com.zhonghuasheng.designpattern.reactor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 事件分发器类。
 */
public class Dispatcher implements Runnable {

    private Map<EventType, EventHandler> eventHandlerMap = new ConcurrentHashMap<EventType, EventHandler>();
    private Selector selector;

    public Dispatcher(Selector selector) {
        this.selector = selector;
        registerEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        registerEventHandler(EventType.READ, new ReadEventHandler(selector));
        registerEventHandler(EventType.WRITE, new WriteEventHandler(selector));
        System.out.println("Dispatcher类中selector.hashCode(): " + selector.hashCode());
    }

    public void registerEventHandler(EventType eventType, EventHandler eventHandler) {
        this.eventHandlerMap.put(eventType, eventHandler);
    }

    public void removeEventHandler(EventType eventType) {
        this.eventHandlerMap.remove(eventType);
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                List<Event> events = selector.selectNewEvent();
                if (events.size() > 0) {
                    for (Event event : events) {
                        if (event == null) {
                            System.out.println("event是null");
                        }
                        EventHandler eventHandler = eventHandlerMap.get(event.getType());

                        if (EventType.DONE == event.getType()) {
                            selector.addFinishedEvent(event);
                            continue;
                        }

                        eventHandler.handle(event);
                        System.out.println("Dispatcher类处理了Event: " + event.getSource().toString());
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
