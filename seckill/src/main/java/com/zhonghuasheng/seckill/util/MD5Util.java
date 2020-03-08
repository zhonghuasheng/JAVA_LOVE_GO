package com.zhonghuasheng.seckill.util;


public class MD5Util {

    public static String md5(String str) {
        System.out.println("org.apache.commons.codec.digest.DigestUtils: " + org.apache.commons.codec.digest.DigestUtils.md5(str));
        System.out.println("org.springframework.util.DigestUtils:" + org.springframework.util.DigestUtils.md5DigestAsHex(str.getBytes()));
        return org.springframework.util.DigestUtils.md5DigestAsHex(str.getBytes());
    }

    private static final String salt = "Abcde12345_";

    public static String mixPassword(String str) {
        String mixStr = salt.charAt(0) + salt.charAt(2) + str + salt.charAt(1) + salt.charAt(3);
        return md5(mixStr);
    }
}
