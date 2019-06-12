package com.zhonghuasheng.basic.java.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {

    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        try {
            // "r" 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
            // "rw" 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。
            randomAccessFile = new RandomAccessFile(
                    "E:\\code\\JAVA\\basic\\src\\main\\java\\com\\zhonghuasheng\\basic\\java\\io\\write.log", "r");
            String str = null;
            while((str = randomAccessFile.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
