package com.zhonghuasheng.spring4.condition;

public class LinuxCommandShow implements CommandShow {

    @Override
    public void showListCmd() {
        System.out.println("Linux List Command: ls");
    }
}
