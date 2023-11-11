package com.zhonghuasheng.netty.websocket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http2.Http2Codec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.apache.log4j.Logger;

public class WebSocketServer {

    private final Logger logger = Logger.getLogger(this.getClass());

    public static void main(String[] args) {
        new WebSocketServer().start(8002);
    }

    public void start(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast("logging", new LoggingHandler(LogLevel.DEBUG))
                                .addLast("http-codec", new HttpServerCodec()) // HttpRequestDecoder和HttpResponseEncoder的一个组合，针对http协议进行编解码
                                .addLast("aggregator", new HttpObjectAggregator(65536)) // 需要放到HttpServerCodec这个处理器后面
                                .addLast("http-chunked", new ChunkedWriteHandler()) // 分块向客户端写数据，防止发送大文件时导致内存溢出， channel.write(new ChunkedFile(new File("bigFile.mkv")))
                                .addLast("handler", new WebSocketHandler());
                    }
                });
        Channel channel = null;
        try {
            channel = serverBootstrap.bind(port).sync().channel();
            logger.info("WebSocket服务器启动： " + channel.id().asShortText());
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            logger.info("WebSocket服务异常");
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            logger.info("WebSocket服务器关闭");
        }
    }
}
