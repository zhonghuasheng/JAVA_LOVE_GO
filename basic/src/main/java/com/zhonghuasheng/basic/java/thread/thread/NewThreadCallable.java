package com.zhonghuasheng.basic.java.thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThreadCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable newCallable = new NewCallable();
        FutureTask futureTask = new FutureTask(newCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object result = futureTask.get();
        System.out.println(String.valueOf(result));

        Callable<Integer> newCallable2 = new NewCallable2();
        FutureTask<Integer> task = new FutureTask(newCallable2);
        new Thread(task).start();
        Integer i = task.get();
        System.out.println(i);
    }
}
// 实现Callable接口
class NewCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return "Hello World";
    }
}

class NewCallable2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
