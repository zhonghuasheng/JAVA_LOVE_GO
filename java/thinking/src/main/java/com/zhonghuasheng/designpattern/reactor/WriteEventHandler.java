package com.zhonghuasheng.designpattern.reactor;

/**
 * Accept事件处理器实现类。
 */
public class WriteEventHandler extends EventHandler {

    private Selector selector;

    public WriteEventHandler() {
    }

    public WriteEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        if (EventType.WRITE == event.getType()) {
            Event readEvent = new Event();
            readEvent.setSource(event.getSource());
            readEvent.setType(EventType.DONE);
            selector.addFinishedEvent(readEvent);
            System.out.println("WriteEventHandler处理完毕，结束");
        }
    }
}
