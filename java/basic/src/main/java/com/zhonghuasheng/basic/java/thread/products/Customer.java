package com.zhonghuasheng.basic.java.thread.products;

public class Customer {

    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    public void cunsume(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot.consume(val);
            }
        }.start();;
    }
}
