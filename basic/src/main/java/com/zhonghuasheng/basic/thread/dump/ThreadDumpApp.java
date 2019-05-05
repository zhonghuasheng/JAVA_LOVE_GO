package com.zhonghuasheng.basic.thread.dump;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

public class ThreadDumpApp {

    public static void main(String[] args) {
        ThreadInfo[] threads = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true);

        for (final ThreadInfo info : threads) {
            System.out.println(info);
        }
    }

}
