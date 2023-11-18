package com.zhonghuasheng.netty.tcp.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

/**
 * TCP服务端业务处理类
 */
public class BusinessHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(BusinessHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof byte[]) {
            logger.info(String.format("解码后数据为: %s", new String((byte[]) msg, "UTF-8")));
            // 扩展将数据转换为实体对象
        }
    }
}
