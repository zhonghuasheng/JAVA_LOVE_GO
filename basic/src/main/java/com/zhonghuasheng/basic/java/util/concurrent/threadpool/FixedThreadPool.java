package com.zhonghuasheng.basic.java.util.concurrent.threadpool;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool {

    BlockingQueue<Runnable> blockingQueue;
    List<Thread> workers;

    private class Worker extends Thread {

        private FixedThreadPool pool;

        public Worker(FixedThreadPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            while (this.pool.blockingQueue.size() > 0) {
                Runnable task = null;
                try {
                    task = this.pool.blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (task != null) {
                    task.run();
                    System.out.println("线程： " + Thread.currentThread().getName() + "执行完毕");
                }
            }

        }
    }

    public FixedThreadPool(int capacity, int threadPoolSize) {
        if (capacity < 0 || threadPoolSize < 0)
            throw new IllegalArgumentException("非法参数");

        blockingQueue = new LinkedBlockingQueue<>(capacity);
        workers = Collections.synchronizedList(new ArrayList<>(threadPoolSize));

        for (int i = 0; i < threadPoolSize; i++) {
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

    public boolean submit(Runnable task) {
        return this.blockingQueue.offer(task);
    }
}
