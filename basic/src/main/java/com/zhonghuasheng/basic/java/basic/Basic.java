package com.zhonghuasheng.basic.java.basic;

public class Basic {

    public static void main(String[] args) {
        User user1 = new User(1, "a");
        User user2 = new User(1, "a");
        System.out.println(user1 == user2); // false
        System.out.println(user1.equals(user2)); // false Object中的equals使用的是this==obj

        int a = 1;
        int b = 1;
        System.out.println(a == b); // 基础类型没有equals方法 true
        String x = "a";
        String y = new String("a");
        System.out.println(x == y); // false
        System.out.println(x.equals(y));
        Basic equalsOr = new Basic();
        System.out.println(equalsOr.say("ada"));
        System.out.println(Math.round(-1.5));
        // String StringBuffer StringBuilder
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a").append("b");
        // reverse
        String reverseStr = "abcde";
        StringBuffer sb = new StringBuffer(reverseStr);
        System.out.println(sb.reverse());
        char[] chars = reverseStr.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }

    public final String say(String str) {
        return str;
    }
}
