package com.zhonghuasheng.java8.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {

    public static void main(String[] args) throws IOException {
        // Demo1
        FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/com/zhonghuasheng/java8/stream/StreamTest.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
        dataOutputStream.writeInt(1);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeUTF("Stream 测试");
        dataOutputStream.writeUTF("Stream 测试 2");
        // 将写到内存中的数据刷到硬盘中
        dataOutputStream.flush();
        dataOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/zhonghuasheng/java8/stream/StreamTest.txt")));
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readBoolean());
        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readUTF());
        dataInputStream.close();

        // Demo2 写文件
        FileOutputStream fos = new FileOutputStream("StreamTest2.txt");
        fos.write("Stream Test测试".getBytes());
        fos.flush();
        fos.close();

        File file = new File(System.getProperty("user.dir") + "/src/main/java/com/zhonghuasheng/java8/stream/StreamTest2.txt");
        // 第二个参数表示追加
        FileOutputStream fos2 = new FileOutputStream(file, true);
        fos2.write("Hello World Test".getBytes());
        fos2.close();
    }
}
