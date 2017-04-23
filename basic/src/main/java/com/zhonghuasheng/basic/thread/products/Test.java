package com.zhonghuasheng.basic.thread.products;

public class Test {

    public static void main(String[] args) {
        Depot depot = new Depot(10);
        Producer producer = new Producer(depot);
        Customer customer = new Customer(depot);

        producer.produce(6);
        producer.produce(12);
        customer.cunsume(9);
        customer.cunsume(15);
        producer.produce(11);
    }

}
