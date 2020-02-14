package com.zhonghuasheng.basic.java.thread.hook;

import java.util.Scanner;

public class HookThreadExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Begin to run");
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hook");
            }
        }));
        Scanner scanner = new Scanner(System.in);
        // 按Ctrl + x会调用hook thread，idea中按了ctrl+d
        System.out.println(scanner.next());
        Thread.sleep(10000);
        // 执行系统推出会调用hook thread
        System.exit(0);
        System.out.println("End to run");
        // 系统正常退出会调用hook thread
        /**
         * egin to run
         * ^D
         * Hook
         * Exception in thread "main" java.util.NoSuchElementException
         * 	at java.util.Scanner.throwFor(Scanner.java:862)
         * 	at java.util.Scanner.next(Scanner.java:1371)
         * 	at com.zhonghuasheng.basic.java.thread.hook.HookThreadExample.main(HookThreadExample.java:16)
         * ^D
         */
    }
}
