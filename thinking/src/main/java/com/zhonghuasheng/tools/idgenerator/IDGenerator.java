package com.zhonghuasheng.tools.idgenerator;

import java.util.UUID;

public class IDGenerator {

    public static void main(String[] args) {
        /**
         * 生成ID
         * 1. 数据库自增。master上自增，数据迁移会有冲突，分表合并会有问题
         * 2. UUID
         * 3. UUID变种
         */
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid); //36位 d369e408-df7e-443d-a869-9938a41f45c4
        // 参数必须为uuid的String格式
        UUID test = UUID.fromString("d369e408-df7e-443d-a869-9938a41f45c4"); // d369e408-df7e-443d-a869-9938a41f45c4
        System.out.println(test);
        System.out.println(uuid.getLeastSignificantBits()); // 这几个值每次都变，不可用
        System.out.println(uuid.getMostSignificantBits());
        System.out.println(test.getMostSignificantBits());
    }
}
