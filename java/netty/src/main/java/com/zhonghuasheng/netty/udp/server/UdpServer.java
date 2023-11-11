package com.zhonghuasheng.netty.udp.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UdpServer {

    public static void main(String[] args) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ChannelInitializer<NioDatagramChannel>() {
                    protected void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
                        nioDatagramChannel.pipeline()
                                .addLast(new UdpServerHandler());
                    }
                });
        ChannelFuture channelFuture = null;
        try {
            channelFuture = bootstrap.bind(8004).sync();
            channelFuture.channel().closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
