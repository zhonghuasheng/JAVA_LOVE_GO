package com.zhonghuasheng.basic.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemExample {

    public static void main(String[] args) throws IOException {
        BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(brBufferedReader.readLine());
    }
}
