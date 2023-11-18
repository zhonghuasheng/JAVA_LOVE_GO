package com.zhonghuasheng.commons.lang;

import org.apache.commons.lang.RandomStringUtils;

public class GenerateUniqueId {

    /*
     * https://stackoverflow.com/questions/9060428/generate-unique-id
     * */
    private static final int ID_LENGTH = 10;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generateUniqueId());
        }
    }

    public static String generateUniqueId() {
        return RandomStringUtils.randomAlphabetic(ID_LENGTH);
    }
}
