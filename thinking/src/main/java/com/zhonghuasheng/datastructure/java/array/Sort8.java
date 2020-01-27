package com.zhonghuasheng.datastructure.java.array;

/**
 * 常见的八种排序算法
 */
public class Sort8 {

    public static int[] array = new int[] {3, 5, 1, 4, 9, 0, 2, 6, 8, 7};

    public static void main(String[] args) {
        bubbleSort(); // 交换排序：冒泡排序
        selectSort();
    }

    public static void printArray() {
        for (int i : array) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
    /**
     * 交换排序： 冒泡排序 快速排序
     * 冒泡排序算法思想：相邻的两个数字进行比较，值大的往下沉。两层循环，第一层控制比较的次数，第二层控制排序。
     */
    public static void bubbleSort() {
        System.out.println("交换排序：冒泡排序");
        for (int i = 0; i < array.length - 1; i++) {
            int temp = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        printArray();
    }

    public static void selectSort() {
        System.out.println("选择排序");
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        printArray();
    }


}
