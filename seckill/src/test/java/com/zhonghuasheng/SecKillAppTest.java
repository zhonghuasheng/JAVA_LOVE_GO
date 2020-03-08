package com.zhonghuasheng;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SecKillAppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void md5Equal() {
        String str1 = org.apache.commons.codec.digest.DigestUtils.md5Hex("Abcde12345_");
        String str2 = org.springframework.util.DigestUtils.md5DigestAsHex("Abcde12345_".getBytes());
        System.out.println("org.apache.commons.codec.digest.DigestUtils: " + str1);
        System.out.println("org.springframework.util.DigestUtils:" + str2);
        /**
         * org.apache.commons.codec.digest.DigestUtils: 4e8c736c62f543615b8a96ac469c8399
         * org.springframework.util.DigestUtils:4e8c736c62f543615b8a96ac469c8399
         */
        assertTrue( str1.equals(str2) );
    }
}
