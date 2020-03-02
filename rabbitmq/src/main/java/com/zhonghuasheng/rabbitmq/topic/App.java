package com.zhonghuasheng.rabbitmq.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class App {

    public static void main(String[] args) throws IOException, TimeoutException {
        Consumers consumers1 = new Consumers();
        consumers1.receiveMessage("musicstore.*.*");

        Consumers consumers2 = new Consumers();
        consumers2.receiveMessage("*.*.log");

        Consumers consumers3 = new Consumers();
        consumers3.receiveMessage("*.user.*");
        Consumers consumers4 = new Consumers();
        consumers4.receiveMessage("#.user");

        Producer producer = new Producer();
        producer.sendMessage("musicstore.user.log", "musicstore.user.log");
        producer.sendMessage("musicstores.user.log", "musicstores.user.log");
        producer.sendMessage("musicstore.users.log", "musicstore.users.log");
        producer.sendMessage("musicstore.user.logs", "musicstore.user.logs");
        producer.sendMessage("musicstores.user", "musicstores.user");
        /*
            Routing Key is : *.user.* ---Message is: musicstore.user.log
            Routing Key is : *.*.log ---Message is: musicstore.user.log
            Routing Key is : musicstore.*.* ---Message is: musicstore.user.log
            Routing Key is : *.user.* ---Message is: musicstores.user.log
            Routing Key is : *.*.log ---Message is: musicstores.user.log
            Routing Key is : musicstore.*.* ---Message is: musicstore.users.log
            Routing Key is : *.*.log ---Message is: musicstore.users.log
            Routing Key is : *.user.* ---Message is: musicstore.user.logs
            Routing Key is : musicstore.*.* ---Message is: musicstore.user.logs
            Routing Key is : #.user ---Message is: musicstores.user
        * */
    }
}
