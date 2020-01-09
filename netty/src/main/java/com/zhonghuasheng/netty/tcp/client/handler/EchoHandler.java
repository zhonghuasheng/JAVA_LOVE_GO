package com.zhonghuasheng.netty.tcp.client.handler;

import com.alibaba.fastjson.JSON;
import com.zhonghuasheng.netty.tcp.pojo.Person;
import com.zhonghuasheng.netty.tcp.protocol.TcpProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

/**
 * TCP客户端业务类
 * 建立连接后发送一条数据到TCP服务器
 */
public class EchoHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(EchoHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 正常发送
        Person person = new Person("Test User", 18);
        byte[] data = JSON.toJSONBytes(person);
        TcpProtocol tcpProtocol = new TcpProtocol();
        tcpProtocol.setLength(data.length);
        tcpProtocol.setData(data);
        ByteBuf byteBuf = ctx.alloc().buffer();
        byteBuf.writeByte(tcpProtocol.getHeader());
        byteBuf.writeInt(data.length);
        byteBuf.writeBytes(data);
        byteBuf.writeByte(tcpProtocol.getEnd());
        ctx.writeAndFlush(byteBuf);
    }
}
