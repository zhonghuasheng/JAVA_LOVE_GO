package com.zhonghuasheng.basic.java.thread.products;

public class Producer {

    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}
