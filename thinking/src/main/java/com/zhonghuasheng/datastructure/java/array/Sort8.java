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
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[array.length - 1]);
    }

    /**
     * 交换排序： 冒泡排序 快速排序
     * 冒泡排序算法思想：相邻的两个数字进行比较，值大的往下沉。两层循环，第一层控制比较的次数，第二层控制排序。
     *     * 优化措施：
     *         * 第一层：如果在本次循环过程中没有发生数据交换，说明都排好了。
     *         * 第二层优化：记录这次循环过程中最后一次发生数据交换的位置，将该位置作为下次二层循环的最后位置。
     */
    public static void bubbleSort() {
        System.out.println("交换排序：冒泡排序");
        // flag：在一次循环中是否发生了数据交换。true表示发生了。优化外层循环，减少循环次数。
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            int temp = 0;

            // 如果不发生数据交换，说明都排好了。
            if (!flag) {
                break;
            }
            flag = false; // 每次循环设置为false，表示不发生置换。
            int lastSwitchPlace = 0;
            int k = array.length - 1;
            for (int j = 0; j < k; j++) {
                if (array[j] > array[j + 1]) {
                    lastSwitchPlace = j;
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            printArray();
            System.out.println("lastSwitchPlace: " + lastSwitchPlace);
            k = lastSwitchPlace;
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
