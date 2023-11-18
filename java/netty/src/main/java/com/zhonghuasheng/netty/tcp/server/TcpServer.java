package com.zhonghuasheng.netty.tcp.server;

import com.zhonghuasheng.netty.tcp.server.handler.BusinessHandler;
import com.zhonghuasheng.netty.tcp.server.handler.TcpDecoderHandler;
import com.zhonghuasheng.netty.tcp.server.handler.TcpEncoderHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.apache.log4j.Logger;

/**
 * TCP服务端类
 */
public class TcpServer {

    private static final Logger logger = Logger.getLogger(TcpServer.class);

    public static void main(String[] args) {
        new TcpServer().start(8003);
    }

    private void start(int port) {
        // 主线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 工作线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 启动引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                // 配置为NIO的socket通道
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                // 设置log监听
                                .addLast(new LoggingHandler("DEBUG"))
                                // 编码器 | 解码器
                                .addLast(new TcpEncoderHandler())
                                .addLast(new TcpDecoderHandler())
                                // 业务处理类
                                .addLast(new BusinessHandler());
                    }
                })
        // 设置缓冲区
        .option(ChannelOption.SO_BACKLOG, 1024)
        // TCP套接字参数，保持连接
        .childOption(ChannelOption.SO_KEEPALIVE, true);
        ChannelFuture channelFuture = null;
        try {
            // 使用Future来启动线程
            channelFuture = serverBootstrap.bind(port).sync();
            logger.info("TCP服务端启动成功");
            // 以异步的方式关闭端口
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.error("TCP服务端启动异常:" + e);
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            logger.info("TCP服务端关闭");
        }
    }
}
