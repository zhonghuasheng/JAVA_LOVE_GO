package com.zhonghuasheng;

import com.zhonghuasheng.mybatisplus.model.Student;
import org.junit.Test;

public class ActiveRecordTest {

    @Test
    public void testInsert() {
        boolean insert = Student.builder().name("Steven").age(21).build().insert();
        System.out.println(insert);
    }
}
