package com.zhonghuasheng.basic.java.thread.products.single;

public class SingleProductExample {

    public static void main(String[] args) {
        Product product = new Product();
        Thread producer = new Thread(()-> {
            for (int i = 0; i < 20; i++) {
                product.product(10);
            }
        }, "Producer ");
        Thread consumer = new Thread(()-> {
            for (int i = 0; i < 20; i++) {
                product.consume(10);
            }
        }, "Consumer ");
        Thread producer2 = new Thread(()-> {
            for (int i = 0; i < 20; i++) {
                product.product(10);
            }
        }, "Producer2 ");
        Thread consumer2 = new Thread(()-> {
            for (int i = 0; i < 20; i++) {
                product.consume(10);
            }
        }, "Consumer2 ");
        producer.start();
        consumer.start();
        producer2.start();
        consumer2.start();
        /**生产者消费者模型
         * 所谓的生产者消费者模型，是通过一个容器来解决生产者和消费者的强耦合问题。
         * 通俗的讲，就是生产者在不断的生产，消费者也在不断的消费，可是消费者消费的产品是生产者生产的，这就必然存在一个中间容器，
         * 我们可以把这个容器想象成是一个货架，当货架空的时候，生产者要生产产品，此时消费者在等待生产者往货架上生产产品，
         * 而当货架满的时候，消费者可以从货架上拿走商品，生产者此时等待货架的空位，这样不断的循环。
         * 那么在这个过程中，生产者和消费者是不直接接触的，所谓的‘货架’其实就是一个阻塞队列，
         * 生产者生产的产品不直接给消费者消费，而是仍给阻塞队列，这个阻塞队列就是来解决生产者消费者的强耦合的。就是生产者消费者模型。
         *
         * 本例中我们假设只有一个生产者和一个消费者
         * Producer 生产10个，剩余10
         * Producer 生产10个，剩余20
         * Producer 生产10个，剩余30
         * Producer 生产10个，剩余40
         * Producer 生产10个，剩余50
         * Producer 生产10个，剩余60
         * Producer 生产10个，剩余70
         * Consumer 消费10个，剩余60
         * Consumer 消费10个，剩余50
         * Consumer 消费10个，剩余40
         * Consumer 消费10个，剩余30
         * Consumer 消费10个，剩余20
         * Consumer 消费10个，剩余10
         * Consumer 消费10个，剩余0
         * Producer 生产10个，剩余10
         * Producer 生产10个，剩余20
         * Producer 生产10个，剩余30
         * Producer 生产10个，剩余40
         * Producer 生产10个，剩余50
         * Producer 生产10个，剩余60
         * Producer 生产10个，剩余70
         * Producer 生产10个，剩余80
         * Producer 生产10个，剩余90
         * Producer 生产10个，剩余100
         * Consumer 消费10个，剩余90
         * Consumer 消费10个，剩余80
         * Consumer 消费10个，剩余70
         * Consumer 消费10个，剩余60
         * Consumer 消费10个，剩余50
         * Consumer 消费10个，剩余40
         * Consumer 消费10个，剩余30
         * Consumer 消费10个，剩余20
         * Consumer 消费10个，剩余10
         * Consumer 消费10个，剩余0
         * Producer 生产10个，剩余10
         * Producer 生产10个，剩余20
         * Producer 生产10个，剩余30
         * Consumer 消费10个，剩余20
         * Consumer 消费10个，剩余10
         * Consumer 消费10个，剩余0
         */
    }
}
