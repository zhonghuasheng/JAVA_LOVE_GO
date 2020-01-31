package com.zhonghuasheng.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(array, 8, 0, array.length));
        System.out.println(binarySearch(array, 1, 0, array.length));
        System.out.println(binarySearch(array, 10, 0, array.length));
        System.out.println(binarySearch(array, 0, 0, array.length));
    }

    /**
     * 二分查找适用于查找已经排好的序列
     * @param array
     * @param target
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] array, int target, int low, int high) {
        int mid = (low + high) / 2;
        if (target == mid) {
            return mid;
        }

        if (target > array[mid]) {
            mid = binarySearch(array, target, mid, array.length);
        } else {
            mid = binarySearch(array, target, 0, mid);
        }

        return mid;
    }
}
