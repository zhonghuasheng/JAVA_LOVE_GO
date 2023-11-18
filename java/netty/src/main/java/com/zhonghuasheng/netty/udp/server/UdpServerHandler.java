package com.zhonghuasheng.netty.udp.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;


/**
 * UDP业务逻辑类
 */
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    /**
     * DatagramPacket表示存放数据的数据报，基于UDP协议
     * @param ctx
     * @param datagramPacket
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket datagramPacket) throws Exception {
        System.out.println("服务端收到的消息:" + datagramPacket.content().toString(CharsetUtil.UTF_8));
        DatagramPacket packet = new DatagramPacket(Unpooled.copiedBuffer("你好，这里是服务端", CharsetUtil.UTF_8),
                datagramPacket.sender());
        ctx.writeAndFlush(packet);
    }
}
