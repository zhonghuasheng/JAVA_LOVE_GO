package com.zhonghuasheng.netty.tcp.server.handler;

import com.zhonghuasheng.netty.tcp.protocol.TcpProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.log4j.Logger;

/**
 * TCP服务端编码类
 */
public class TcpEncoderHandler extends MessageToByteEncoder {

    private static final Logger logger = Logger.getLogger(TcpEncoderHandler.class);

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object msg, ByteBuf out) throws Exception {
        if (msg instanceof TcpProtocol) {
            TcpProtocol tcpProtocol = (TcpProtocol) msg;
            out.writeByte(tcpProtocol.getHeader());
            out.writeInt(tcpProtocol.getLength());
            out.writeBytes(tcpProtocol.getData());
            out.writeByte(tcpProtocol.getEnd());
            logger.debug("数据编码成功：" + out);
        } else {
            logger.info("数据格式不支持：" + msg.getClass());
        }
    }
}
