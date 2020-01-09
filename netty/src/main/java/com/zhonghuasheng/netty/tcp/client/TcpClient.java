package com.zhonghuasheng.netty.tcp.client;

import com.zhonghuasheng.netty.tcp.client.handler.EchoHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.apache.log4j.Logger;

/**
 * TCP客户端类
 */
public class TcpClient {

    private static final Logger logger = Logger.getLogger(TcpClient.class);

    public static void main(String[] args) {
        new TcpClient().start("127.0.0.1", 8003);
    }

    private void start(String host, int port) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new LoggingHandler("DEBUG"))
                                .addLast(new EchoHandler());
                    }
                });
        ChannelFuture channelFuture = null;
        try {
            channelFuture = bootstrap.connect(host, port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.info("TCP客户端启动异常：" + e);
        } finally {
            workerGroup.shutdownGracefully();
            logger.info("TCP客户端关闭");
        }
    }
}
