package com.zhonghuasheng.netty.sample.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class Server {

    public static void main(String[] args) {
        // boss线程组用于服务端接受客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // worker线程组用于处理已经被接收的连接，一旦bossGroup接收连接，就会把连接信息注册到workerGroup上
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // Netty的启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // 说明一个新的Channel如何接收进来的连接
                    .handler(new LoggingHandler(LogLevel.INFO)) // 打印日志级别
                    .childHandler(new ServerInitializer());
            // 绑定端口，开始接收连接
            ChannelFuture channelFuture = serverBootstrap.bind(8888);
            // 等待服务端口关闭
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
