package com.zhonghuasheng.rabbitmq.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class App {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Consumers consumers1 = new Consumers();
        consumers1.receiveMessage();

        Consumers consumers2 = new Consumers();
        consumers2.receiveMessage();

        Consumers consumers3 = new Consumers();
        consumers3.receiveMessage();

        Producer producer = new Producer();
        producer.sendMessage();
    }
}
