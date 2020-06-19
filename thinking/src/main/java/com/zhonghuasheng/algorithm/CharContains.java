package com.zhonghuasheng.algorithm;

import java.util.regex.Pattern;

public class CharContains {

    public static void main(String[] args) {
        System.out.println(isContains(args));
    }

    public static boolean isContains(String[] args) {
        if (args == null || args.length <=2) {
            return false;
        }

        String input1 = args[0];
        String input2 = args[1];

        if (input1.length() < input2.length()) {
            return false;
        }

        if (input1.length() <= 5 || input2.length() <= 5) {
            return false;
        }

        if (isUpperWords(input1) || isUpperWords(input2)) {
            return false;
        }

        return input1.contains(input2);
    }

    public static boolean isUpperWords(String input) {
        return input.matches("[A-Z]+$");
    }
}
