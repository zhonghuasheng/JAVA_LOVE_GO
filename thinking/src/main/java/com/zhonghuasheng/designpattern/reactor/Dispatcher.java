package com.zhonghuasheng.designpattern.reactor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 事件分发器类。
 */
public class Dispatcher {

    private Map<EventType, EventHandler> eventHandlerMap = new ConcurrentHashMap<EventType, EventHandler>();
    private Selector selector;

    public Dispatcher(Selector selector) {
        this.selector = selector;
    }

    public void registerEventHandler(EventType eventType, EventHandler eventHandler) {
        this.eventHandlerMap.put(eventType, eventHandler);
    }

    public void removeEventHandler(EventType eventType) {
        this.eventHandlerMap.remove(eventType);
    }

    public void handleEvents() {
        while(true) {
            List<Event> events = selector.select();
            for (Event event : events) {
                EventHandler eventHandler = eventHandlerMap.get(event.getType());
                System.out.println("进入Dispatcher...");
                eventHandler.handle(event);
            }
        }
    }
}
