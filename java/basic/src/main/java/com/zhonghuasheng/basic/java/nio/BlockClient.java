package com.zhonghuasheng.basic.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockClient {

    public static void main(String[] args) throws IOException {
        // 1. 获取通道，注意必须服务端先启动，否则会报connect refuse的error
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
        // 2. 发送一个文件给服务器。创建channel通道
        FileChannel fileChannel = FileChannel.open(Paths.get(System.getProperty("user.dir") + "\\src\\main\\java\\com\\zhonghuasheng\\basic\\App.java"), StandardOpenOption.READ);
        // 3. 创建buffer，与数据打交道
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 4. 读取本地文件发送给服务器
        while (fileChannel.read(buffer) != -1) {
            // 切换成读的模式
            buffer.flip();
            // 通道传送数据
            socketChannel.write(buffer);
            // 读完切换成写模式，能让通道继续读取文件的数据
            buffer.clear();
        }

        // 告诉服务器我已经写完了
        socketChannel.shutdownInput();
        // 5. 关闭流
        fileChannel.close();
        socketChannel.close();
        System.out.println("Client Done");
    }

}
