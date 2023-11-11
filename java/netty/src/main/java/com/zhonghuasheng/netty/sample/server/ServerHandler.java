package com.zhonghuasheng.netty.sample.server;

import io.netty.channel.*;

import java.net.InetAddress;
import java.util.Date;

@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext chx) throws Exception {
        chx.write("Welcome to" + InetAddress.getLocalHost().getHostName() + "\r\n");
        chx.write("It is " + new Date() + " now.\r\n");
        chx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String request) throws Exception {
        String response;
        boolean close = false;
        // 打印channel的ID，测试一个Client是不是始终对应一个Channel，结果显示是一个Channel
        System.out.println("Server Channel ID: " + channelHandlerContext.channel().id().asLongText());
        if (request == null || request.isEmpty()) {
            response = "Please type something. \r\n";
        } else if ("bye".equals(request.toLowerCase())) {
            response = "Have a good day!\r\n";
            close = true;
        } else {
            response = "Did you say '" + request + "'?\r\n";
        }

        ChannelFuture future = channelHandlerContext.write(response);

        if (close) {
            // 当Server端接受到Bye的时候关闭这个连接对应的Channel，其他Channel依旧保持
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext chc) {
        chc.flush();
    }
}
