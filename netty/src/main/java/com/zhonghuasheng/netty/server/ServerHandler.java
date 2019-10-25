package com.zhonghuasheng.netty.server;

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
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext chc) {
        chc.flush();
    }
}
