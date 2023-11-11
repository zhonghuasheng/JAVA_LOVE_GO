package com.zhonghuasheng.basic.java.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class ByteBufferExample {

    public static void main(String[] args) {
        System.out.println("------ByteBuffer Example------");
        ByteBuffer bb = ByteBuffer.allocate(1024);
        // Buffer的4个核心变量
        System.out.println("Initial limit: " + bb.limit()); // 1024
        System.out.println("Initial position: " + bb.position()); // 0
        System.out.println("Initial capacity: " + bb.capacity()); // 1024
        System.out.println("Initial mark: " + bb.mark()); // java.nio.HeapByteBuffer[pos=0 lim=1024 cap=1024]

        // 添加一些数据到缓冲区
        String string = "Hello! ";
        // put中是Byte数组，这也说明了capacity是不可变的，因为底层使用的是数组
        bb.put(string.getBytes());
        System.out.println("After put a wrod limit: " + bb.limit()); // 1024
        System.out.println("After put a wrod position: " + bb.position()); // 7
        System.out.println("After put a wrod capacity: " + bb.capacity()); // 1024
        System.out.println("After put a wrod mark: " + bb.mark()); // java.nio.HeapByteBuffer[pos=7 lim=1024 cap=1024]
        // 切换成读模式
        bb.flip();
        System.out.println("After flip limit: " + bb.limit()); // 7
        System.out.println("After flip position: " + bb.position()); // 0
        System.out.println("After flip capacity: " + bb.capacity()); // 1024
        System.out.println("After flip mark: " + bb.mark()); // java.nio.HeapByteBuffer[pos=0 lim=7 cap=1024]
        /* while (bb.hasRemaining()) {
            System.out.println(bb.get());
        }*/
        byte[] bytes = new byte[bb.limit()];
        bb.get(bytes);
        System.out.println(new String(bytes));
        System.out.println("After get: " + bb.limit());
        System.out.println("After get: " + bb.position());
        System.out.println("After get: " + bb.capacity());
        System.out.println("After get: " + bb.mark());


        System.out.println("------CharBuffer Example------");
        CharBuffer cb = CharBuffer.allocate(1024);
        // Buffer的4个核心变量
        System.out.println("Initial limit: " + cb.limit()); // 1024
        System.out.println("Initial position: " + cb.position()); // 0
        System.out.println("Initial capacity: " + cb.capacity()); // 1024
        System.out.println("Initial mark: " + cb.mark()); // java.nio.HeapByteBuffer[pos=0 lim=1024 cap=1024]

        // 添加一些数据到缓冲区
        String string1 = "Hello!";
        // put中是Byte数组，这也说明了capacity是不可变的，因为底层使用的是数组
        cb.put(string);
        System.out.println("After put a wrod limit: " + cb.limit()); // 1024
        System.out.println("After put a wrod position: " + cb.position()); // 7
        System.out.println("After put a wrod capacity: " + cb.capacity()); // 1024
        System.out.println("After put a wrod mark: " + cb.mark()); // java.nio.HeapByteBuffer[pos=7 lim=1024 cap=1024]
        // 切换成读模式
        cb.flip();
        System.out.println("After flip limit: " + cb.limit()); // 7
        System.out.println("After flip position: " + cb.position()); // 0
        System.out.println("After flip capacity: " + cb.capacity()); // 1024
        System.out.println("After flip mark: " + cb.mark()); // java.nio.HeapByteBuffer[pos=0 lim=7 cap=1024]
        while (cb.hasRemaining()) {
            System.out.println(cb.get());
        }
        // 读完我们还想写数据到缓冲区，使用clear()函数, clear会自动切换读写
        System.out.println("After clear--");
        cb.clear();
        cb.put("World");
        cb.flip();
        char[] dst = new char[cb.length()];
        cb.get(dst);
        System.out.println(new String(dst));
    }
}
