package com.zhonghuasheng.basic.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockServer {

    public static void main(String[] args) throws IOException {
        // 1. 获取通道
        ServerSocketChannel server = ServerSocketChannel.open();
        // 2. 得到文件通道
        FileChannel outChannel = FileChannel.open(Paths.get(System.getProperty("user.dir") + "\\src\\main\\java\\com\\zhonghuasheng\\basic\\nio.txt"), StandardOpenOption.WRITE);
        // 3. 绑定连接
        server.bind(new InetSocketAddress(6666));
        // 4. 获取客户端的连接（阻塞的）
        SocketChannel client = server.accept();
        // 5. 创建与数据打交道的buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 6. 将client传过来的数据写入本地
        while (client.read(buffer) != -1) {
            // 切换成读模式
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        // 7. 关闭通道
        outChannel.close();
        client.close();
        server.close();
        System.out.println("Server Done");
    }

}
