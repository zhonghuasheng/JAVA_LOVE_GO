package com.zhonghuasheng.algorithm.lru;

/**
 * @description LRU算法测试
 */
public class LRUMain {

    public static void main(String[] args) {
        String str = "1";
        Integer result = getFirstNum(str);
        System.out.println(result);
    }

    /**
     * 获取参数中str第一个合法数字
     * @param str
     * @return
     */
    public static Integer getFirstNum(String str) {
        // 判断字符串合法性
        if (str == null || str.length() == 0) {
            return null;
        }
        // 将字符串转化为字符数组
        char[] chars = str.toCharArray();
        // 标记第一个合法数字初始位置
        int firstIndex = 0;
        // 标记firstIndex后第一个非法整数位置
        int lastIndex = 0;
        // 遍历chars
        for (int i = 0; i < chars.length; i++) {
            char charVar = chars[i];
            String charStr = String.valueOf(charVar);
            // 判断是否是数字
            Boolean isNum = isNum(charStr);
            // 是数字，且第一次出现，标记firstIndex
            if (isNum && firstIndex == 0) {
                firstIndex = i;
            } else if (!isNum && firstIndex > 0) {
                // 不是数字，且firstIndex已出现，标记lastIndex
                lastIndex = i;
                break;
            } else if (isNum && firstIndex > 0 && charStr.equals("-")) {
                lastIndex = i;
                break;
            } else {
                // NOTHING TODO
            }
        }
        // 判断是否存在合法结果
        if (firstIndex > 0 && lastIndex > 0) {
            String result = str.substring(firstIndex, lastIndex);
            return Integer.valueOf(result);
        } else {
            return null;
        }
    }

    /**
     * 判断是否是数字
     * @param charStr
     * @return
     */
    public static Boolean isNum(String charStr) {
        String numsList = "-123456789";
        return numsList.contains(charStr);
    }
}
