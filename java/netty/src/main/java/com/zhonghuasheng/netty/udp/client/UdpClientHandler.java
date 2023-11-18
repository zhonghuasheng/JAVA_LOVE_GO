package com.zhonghuasheng.netty.udp.client;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.String;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;


public class UdpClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DatagramPacket packet = new DatagramPacket(Unpooled.copiedBuffer("来自客户端的问候", CharsetUtil.UTF_8),
                new InetSocketAddress("255.255.255.255", 8004));
        ctx.writeAndFlush(packet).sync();

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket datagramPacket) throws Exception {
        System.out.println("客户端读取的数据：" + datagramPacket.content().toString(CharsetUtil.UTF_8));
    }
}
