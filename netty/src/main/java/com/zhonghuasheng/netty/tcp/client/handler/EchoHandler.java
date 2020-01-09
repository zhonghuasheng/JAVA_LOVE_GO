package com.zhonghuasheng.netty.tcp.client.handler;

import com.alibaba.fastjson.JSON;
import com.zhonghuasheng.netty.tcp.pojo.Person;
import com.zhonghuasheng.netty.tcp.protocol.TcpProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

import java.util.Arrays;

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

        // 拆包发送
        Person person2 = new Person("Test User2", 19);
        byte[] data2 = JSON.toJSONBytes(person2);
        TcpProtocol tcpProtocol2 = new TcpProtocol();
        tcpProtocol2.setLength(data2.length);
        tcpProtocol2.setData(data2);
        byteBuf = ctx.alloc().buffer();
        byteBuf.writeByte(tcpProtocol2.getHeader());
        byteBuf.writeInt(data2.length);
        byteBuf.writeBytes(Arrays.copyOfRange(data2, 0, data2.length / 2));
        ctx.writeAndFlush(byteBuf);
        byteBuf = ctx.alloc().buffer();
        byteBuf.writeBytes(Arrays.copyOfRange(data, data2.length / 2, data2.length));
        byteBuf.writeByte(tcpProtocol.getEnd());
        ctx.writeAndFlush(byteBuf);

        // 粘包发送
        Person person3 = new Person("Test User3", 20);
        byte[] data3 = JSON.toJSONBytes(person3);
        TcpProtocol tcpProtocol3 = new TcpProtocol();
        tcpProtocol3.setLength(data3.length);
        tcpProtocol3.setData(data3);
        byteBuf = ctx.alloc().buffer();
        // 粘包第一帧
        byteBuf.writeByte(tcpProtocol.getHeader());
        byteBuf.writeInt(data.length);
        byteBuf.writeBytes(data);
        byteBuf.writeByte(tcpProtocol.getEnd());
        // 粘包第二帧
        byteBuf.writeByte(tcpProtocol2.getHeader());
        byteBuf.writeInt(data2.length);
        byteBuf.writeBytes(data2);
        byteBuf.writeByte(tcpProtocol2.getEnd());
        // 粘包第三帧
        byteBuf.writeByte(tcpProtocol3.getHeader());
        byteBuf.writeInt(data3.length);
        byteBuf.writeBytes(data3);
        byteBuf.writeByte(tcpProtocol3.getEnd());
        ctx.writeAndFlush(byteBuf);
    }
}
