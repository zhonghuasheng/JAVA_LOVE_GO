package com.zhonghuasheng.rabbitmq.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class App {

    public static void main(String[] args) throws IOException, TimeoutException {
        Consumers consumers1 = new Consumers();
        consumers1.receiveMessage("info");

        Consumers consumers2 = new Consumers();
        consumers2.receiveMessage("error");

        Consumers consumers3 = new Consumers();
        consumers3.receiveMessage("info");

        Producer producer = new Producer();
        producer.sendMessage();
    }
}
