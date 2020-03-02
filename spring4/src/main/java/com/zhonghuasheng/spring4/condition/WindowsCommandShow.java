package com.zhonghuasheng.spring4.condition;

public class WindowsCommandShow implements CommandShow {

    @Override
    public void showListCmd() {
        System.out.println("Windows List Command: dir");
    }
}
