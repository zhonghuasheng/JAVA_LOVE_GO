package com.zhonghuasheng.datastructure.java.array;

import java.util.Arrays;

/**
 * 常见的八种排序算法
 */
public class Sort8 {

    public static int[] basicArray = new int[] {3, 5, 1, 4, 9, 0, 2, 6, 8, 7};

    public static void main(String[] args) {
        bubbleSort(); // 交换排序：冒泡排序
        System.out.println("交换排序：快速排序");
        int[] array = Arrays.copyOf(basicArray, basicArray.length);
        quickSort(array, 0, array.length - 1); // 交换排序： 快速排序
        printArray(array);
        insertSort();
        selectSort();
        shellSort();
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[array.length - 1]);
    }

    /**
     * 交换排序： 冒泡排序
     * 冒泡排序算法思想：相邻的两个数字进行比较，值大的往下沉。两层循环，第一层控制比较的次数，第二层控制排序。
     *     * 优化措施：
     *         * 第一层：如果在本次循环过程中没有发生数据交换，说明都排好了。
     *         * 第二层优化：记录这次循环过程中最后一次发生数据交换的位置，将该位置作为下次二层循环的最后位置。
     */
    public static void bubbleSort() {
        System.out.println("交换排序：冒泡排序");
        int[] array = Arrays.copyOf(basicArray, basicArray.length);
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
            printArray(array);
            System.out.println("lastSwitchPlace: " + lastSwitchPlace);
            k = lastSwitchPlace;
        }

        printArray(array);
    }

    /**
     * 交换排序： 快速排序
     *     * 快速排序算法思想：快速排序之所有列入交换排序，是因为在排序的过程中它也涉及了调换数字顺序，不同于冒泡排序的只能和相邻的数字交换顺序，快速排序可以
     *     跳动着交换数字。快速排序是冒泡排序的演进版，最坏的可能是每次调换都是挨着的调换。其思想是选取一个基准值（一般选择第一个数字），然后定义一个左边的初始位置
     *     low，和右边的初始位置high，左边i向右逐次增加，直到找到第一个大于基准数的值（这个值是需要放到右边），右边j向左逐次减小，直到找到第一个小于基准数的值
     *     （这个值是需要放到左边），找到后，调换顺序，然后i,j继续推进，直到i和j相遇或者不能满足j<j的条件。这时候j右侧的值都是大于基准值的，j左侧的值（第一个基准值
     *     除外）都是小于基准值的，数组被划分为2，这就是分而治之。然后分别对左边和右边进行相同的操作，也就是递归调用。
     * @param array
     * @param low 最小位置索引
     * @param high 最大位置索引
     */
    public static void quickSort(int[] array, int low, int high) {
        // 这个判断很重要，如果不在这里加这个判断，那么需要在递归调用处判断传入的low和high的值
        if (low > high) {
            return;
        }
        int i = low; // 最左边的位置
        int j = high; // 最右边的位置
        int temp = array[low];

        while (i < j) {
            // 先从右边找到比基准值temp小的数
            while (temp <= array[j] && i < j) {
                j--;
            }

            // 再从左边找到比基准值temp大的数
            while (temp >= array[i] && i < j) {
                i++;
            }

            // 左右跳跃调整
            int t;
            if (i < j) {
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        // 最后的地方是i和j重合的地方，或者挨着的地方（i=j-1），此时将最开始的基准值调到i的位置
        array[low] = array[i];
        array[i] = temp;

        // 递归调用调整左半个数组。递归调用时需要
        quickSort(array, low, j - 1); // 也就是i的位置
        // 递归调用调整右半个数组
        quickSort(array, j + 1, high);
    }

    /**
     * 直接插入排序：将一个记录插入到已经排好序的序列中，从而得到一个新的有序序列。将序列的第一个数据看成是一个有序的子序列，然后从第二个记录逐个向该有序的
     * 子序列进行有序的插入，直至真个序列有序。适合基本有序并且数据量小的排序。
     */
    public static void insertSort() {
        System.out.println("直接插入排序：");
        int[] array = Arrays.copyOf(basicArray, basicArray.length);
        for (int i = 1; i < array.length; i++) {
            int temp;
            // 后面的数比前面的小，需要向前插入
            if (array[i - 1] > array[i]) {
                temp = array[i];
                // 从后向前遍历已经排好的序列，将temp插入到合适的位置，需要移动的元素是在temp和i之间的元素
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && array[j - 1] > temp ) {
                        array[j] = array[j - 1];
                    } else {
                        // 第一次出现array[j - 1] <= temp时，插入替换，然后跳出里层循环
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
        printArray(array);
    }

    /**
     * 希尔排序是对直接插入排序的一种改进，实际上是分组插入排序，适合数据量较大的排序。算法的基本思想是对于n个待排序的数列，取一个小于n的整数gap作为
     * 步长，将待排序的元素分成若干个子序列，所有距离为gap的倍数的记录放到同一个组中。然后对各组内的元素进行直接插入排序。然后减少gap的值，并重复执行
     * 上述的分组和排序，重复这样的操作，当gap=1时，整个数列就是有序的。
     */
    public static void shellSort() {
        System.out.println("希尔排序：");
        int[] array = Arrays.copyOf(basicArray, basicArray.length);
        // 外层控制分组的步长，需要考虑数组的长度是基数还是偶数
        for (int gap = array.length / 2; gap > 0; gap -= 2) {
            // 里层是直接插入排序的算法
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j+= gap) {
                    if (array[j - gap] > array[j]) {
                        int temp = array[j];
                        int k = j - gap;
                        while (k >= 0 && array[k] > temp) {
                            array[k + gap] = array[k];
                            k -= gap;
                        }
                        array[k + gap] = temp;
                    }
                }
            }
        }
        printArray(array);
    }

    public static void selectSort() {
        System.out.println("选择排序：");
        int[] array = Arrays.copyOf(basicArray, basicArray.length);
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

        printArray(array);
    }


}
