package com.zhonghuasheng.designpattern.reactor;

/**
 * 事件类。将输入的原始对象根据不同状态包装成一个事件类，reactor模式里处理的都是event事件对象。
 */
public class Event {

    private InputSource source;
    private EventType type;

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
