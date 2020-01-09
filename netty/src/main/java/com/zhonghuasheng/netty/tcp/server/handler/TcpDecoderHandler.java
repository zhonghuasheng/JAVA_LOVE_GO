package com.zhonghuasheng.netty.tcp.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * TCP服务端解码类
 */
public class TcpDecoderHandler extends ByteToMessageDecoder {

    private static final Logger logger = Logger.getLogger(TcpDecoderHandler.class);
    // 最小数据长度：header和end(各1个字节)，length为int类型（占4个字节）
    private static int MIN_DATA_LENGTH = 6;
    // 数据解码协议开始标识
    private static byte PROTOCOL_HEADER = 0x58;
    // 数据解码协议结束标识
    private static byte PROTOCOL_END = 0x63;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf bufIn, List<Object> out) throws Exception {
        if (bufIn.readableBytes() <= MIN_DATA_LENGTH) {
            logger.info("数据长度不符合要求");
            return;
        }

        // 标记读操作标识位
        bufIn.markReaderIndex();
        // 读取第一个字节
        byte header = bufIn.readByte();
        if (header != PROTOCOL_HEADER) {
            logger.info("数据格式不正确，header错误");
            return;
        }

        int length = bufIn.readInt();
        // 数据未到齐
        if (length >= bufIn.readableBytes()) {
            logger.info(String.format("数据未到齐，数据协议长度为%d，实际长度为%d", length, bufIn.readableBytes()));
            // 重置读操作标识位
            bufIn.resetReaderIndex();
            return;
        }

        byte[] data = new byte[length];
        bufIn.readBytes(data);

        byte end = bufIn.readByte();
        if (end != PROTOCOL_END) {
            logger.info("数据格式不正确，end错误");
            return;
        }

        out.add(data);
    }
}
