package com.zhonghuasheng.java8.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListToMapLoadTestStream {

    public static void main(String[] args) {
        // loop-stream 10000 use501毫秒
        // loop-stream 100000 use628毫秒
        // loop-stream 1000000 use1179毫秒
        loadTestStream(1000000);
    }

    private static void loadTestStream(int num) {
        List<Price> prices = new ArrayList<>();

        for (int i = 0; i <= num; i++) {
            Price price = new Price();
            price.setName("Price" + i);
            price.setValue(Double.valueOf(i));
            prices.add(price);
        }

        System.out.println("数据准备结束。");

        HashMap<String, Double> map = new HashMap<>(prices.size());
        System.out.println("Stream将List转换为HashMap开始");
        long timeBegin = System.nanoTime();
        prices.stream().collect(Collectors.toMap(Price::getName, Price::getValue));
        long timeEnd = System.nanoTime();
        System.out.println("loop-stream use" + (timeEnd - timeBegin) / 100000 + "毫秒");
        /*
        * 结论：
        * Java8 Stream在处理将List转换为Map的时候性能没有使用for循环处理高
        */
    }
}
