package com.zhonghuasheng.algorithm;

/**
 * 二分查找的使用条件和场景：
 *   1. 待查找的数据序列必须有序
 *   2. 待查找的数据序列需要使用数组进行存储
 *   3. 数据量太大或者太小都不适合使用二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("递归实现二分查找不重复的有序数组中的目标元素下标");
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(array, 8, 0, array.length));
        System.out.println(binarySearch(array, 1, 0, array.length));
        System.out.println(binarySearch(array, 10, 0, array.length));
        System.out.println(binarySearch(array, 0, 0, array.length));
        System.out.println("迭代实现二分查找重复的有序数组中的第一个目标元素下标");
        int[] array2 = {0, 1, 2, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10, 20};
        System.out.println(binarySearch2(array2, 0, 0, array2.length)); // 0
        System.out.println(binarySearch2(array2, 2, 0, array2.length)); // 2
        System.out.println(binarySearch2(array2, 3, 0, array2.length)); // 4
        System.out.println(binarySearch2(array2, 5, 0, array2.length)); // 6
        System.out.println(binarySearch2(array2, 7, 0, array2.length)); // 10
        System.out.println(binarySearch2(array2, 10, 0, array2.length)); // 14
        System.out.println(binarySearch2(array2, 20, 0, array2.length)); // 15
        System.out.println("迭代实现二分查找重复的有序数组中的最后一个目标元素下标");
        int[] array3 = {0, 1, 2, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10, 20};
        System.out.println(binarySearch3(array2, 0, 0, array2.length)); // 0
        System.out.println(binarySearch3(array2, 2, 0, array2.length)); // 3
        System.out.println(binarySearch3(array2, 3, 0, array2.length)); // 4
        System.out.println(binarySearch3(array2, 5, 0, array2.length)); // 7
        System.out.println(binarySearch3(array2, 7, 0, array2.length)); // 11
        System.out.println(binarySearch3(array2, 10, 0, array2.length)); // 14
        System.out.println(binarySearch3(array2, 20, 0, array2.length)); // 15
    }

    /**
     * 二分查找适用于查找已经排好的序列，此次数组为不重复的有序数组
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

    /**
     * 查找有序序列中第一个匹配的值的下标
     * @param array
     * @param target
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch2(int[] array, int target, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                if (mid == 0 || array[mid - 1] != target) {
                    return mid;
                }
            } else {
                if (array[mid] < target) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }

        return -1;
    }

    public static int binarySearch3(int[] array, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                if (mid == (high - 1) || array[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid;
                }
            } else {
                if (array[mid] > target) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
        }

        return -1;
    }
}
