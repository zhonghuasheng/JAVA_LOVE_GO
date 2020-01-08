package com.zhonghuasheng.netty.http.server;

import com.zhonghuasheng.netty.http.util.ByteBufToBytes;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

public class NettyHttpServerHandler extends ChannelInboundHandlerAdapter {

    private ByteBufToBytes reader;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            System.out.println("messageType: " + request.headers().get("messageType"));
            System.out.println("businessType: " + request.headers().get("businessType"));
            if (HttpUtil.isContentLengthSet(request)) {
                reader = new ByteBufToBytes((int) HttpUtil.getContentLength(request));
            }
        }

        if (msg instanceof HttpContent) {
            HttpContent httpContent = (HttpContent) msg;
            ByteBuf content = httpContent.content();
            reader.reading(content);
            content.release();
            if (reader.isEnd()) {
                String result = new String(reader.readFull());
                System.out.println("Client said: " + result);
                FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                        Unpooled.wrappedBuffer("I am OK".getBytes()));
                response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN);
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
                response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
                ctx.write(response);
                ctx.flush();
            }
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
