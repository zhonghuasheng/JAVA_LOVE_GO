package com.zhonghuasheng.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class L01Sum {

    static {
        System.out.println("测试静态代码块是否优于main方法先执行 - 是");
    }
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] result = new L01Sum().twoSum(array, 9);
        System.out.println(Arrays.toString(result));
        int[] result2 = new L01Sum().towSum(array, 9);
        System.out.println(Arrays.toString(result2));
    }

    /**
     * 时间复杂度O(n2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == (target - nums[i])) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度 O(N)，N为数组中的元素数量
     * 空间复杂度O(N), N为数组中的元素数量
     * @param nums
     * @param target
     * @return
     */
    public int[] towSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] {hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
