package com.zhonghuasheng.designpattern.reactor;

import java.util.List;

public class Notifier implements Runnable {

    private Selector selector;

    public Notifier(Selector selector) {
        this.selector = selector;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            List<Event> events = selector.selectFinishedEvent();
            // TODO Notify connector do something
        }
    }
}
