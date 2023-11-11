package com.zhonghuasheng.netty.http.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.net.URISyntaxException;

public class HttpClient {

    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        httpClient.connect("127.0.0.1", 8001);
    }

    private void connect(String ip, int port) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new HttpResponseDecoder())
                                .addLast(new HttpRequestEncoder())
                                .addLast(new HttpClientHandler());
                    }
                });
        try {
            ChannelFuture channelFuture = bootstrap.connect(ip, port).sync();
            URI uri = new URI("http://127.0.0.1:8001");
            String msg = "Hello Server";
            DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, uri.toASCIIString(),
                    Unpooled.wrappedBuffer(msg.getBytes()));
            // 构建http请求
            request.headers().set(HttpHeaderNames.HOST, ip)
                    .set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE)
                    .set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes())
                    .set("messageType", "normal")
                    .set("businessType", "testServerState");
            // 发送http请求
            channelFuture.channel().write(request);
            channelFuture.channel().flush();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }

    }
}
