package com.zhonghuasheng.java8.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListToMapLoadTestFor {

    public static void main(String[] args) {
        // 10000 loop-for use25毫秒
        // 100000 loop-for use176毫秒
        // 1000000 loop-for use626毫秒
        loadTestFor(1000000);
    }

    private static void loadTestFor(int num) {
        List<Price> prices = new ArrayList<Price>();

        for (int i = 0; i <= num; i++) {
            Price price = new Price();
            price.setName("Price" + i);
            price.setValue(Double.valueOf(i));
            prices.add(price);
        }

        System.out.println("数据准备结束。");

        HashMap<String, Double> map = new HashMap<>(prices.size());
        System.out.println("For循环将List转换为HashMap开始");
        long timeBegin = System.nanoTime();
        for (Price price : prices) {
            map.put(price.getName(), price.getValue());
        }
        long timeEnd = System.nanoTime();
        System.out.println("loop-for use" + (timeEnd - timeBegin) / 100000 + "毫秒");
    }
}
