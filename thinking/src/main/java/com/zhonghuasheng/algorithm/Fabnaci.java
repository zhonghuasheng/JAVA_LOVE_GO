package com.zhonghuasheng.algorithm;

public class Fabnaci {

    public static void main(String[] args) {
        System.out.println(fabnaci(1));
        System.out.println(fabnaci(2));
        System.out.println(fabnaci(3));
        System.out.println(fabnaci(4));
        System.out.println(fabnaci(5));
        System.out.println(fabnaci(6));
    }

    public static int fabnaci(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            // 存在重复计算的问题（计算f(4)+f(3)，f4=f(3)+f(2),在上一步中f(3）已经计算过了），可以考虑使用散列表来保存已经计算过的值
            return fabnaci(n - 1) + fabnaci(n - 2);
        }
    }
}
