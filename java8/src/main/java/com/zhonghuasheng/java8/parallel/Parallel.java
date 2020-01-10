package com.zhonghuasheng.java8.parallel;

import java.util.stream.Stream;

public class Parallel {

    public static void main(String[] args) {
        System.out.println("Start parallelSum");
        Long start1 = System.currentTimeMillis();
        parallelSum(1000L);
        System.out.println(System.currentTimeMillis() - start1);

        System.out.println("Start test2");
        Long start2 = System.currentTimeMillis();
        test2(1000L);
        System.out.println(System.currentTimeMillis() - start2);
    }

    public static Long parallelSum(Long n) {
        return Stream.iterate(1L, i -> 1 + 1L)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static Long test2(Long n) {
        Long result = 0L;

        for(int i = 1; 1 < n; i++) {
            result = result + i;
        }

        return result;
    }
}
