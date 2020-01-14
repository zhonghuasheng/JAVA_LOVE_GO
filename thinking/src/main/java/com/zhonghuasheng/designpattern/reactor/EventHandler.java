package com.zhonghuasheng.designpattern.reactor;

/**
 * 事件处理抽象类。包含不同事件处理器的公共逻辑和公共对象。
 */
public abstract class EventHandler {

    private InputSource inputSource;

    public InputSource getInputSource() {
        return inputSource;
    }

    public void setInputSource(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    abstract void handle(Event event);
}
