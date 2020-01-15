package com.zhonghuasheng.designpattern.reactor;

/**
 * Accept事件处理器实现类。
 */
public class ReadEventHandler extends EventHandler {

    private Selector selector;

    public ReadEventHandler() {
    }

    public ReadEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        if (EventType.READ == event.getType()) {
            Event readEvent = new Event();
            readEvent.setSource(event.getSource());
            readEvent.setType(EventType.WRITE);
            selector.addEvent(readEvent);
            System.out.println("ReadEventHandler处理完毕，进入下一阶段 -》 WRITE");
        }
    }
}
