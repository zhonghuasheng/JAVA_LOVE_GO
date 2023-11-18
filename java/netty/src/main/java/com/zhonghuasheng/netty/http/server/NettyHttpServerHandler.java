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
        // FullHttpRequest包含头HttpRequest，中间可以是多个HttpContent，尾LastHttpContent
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            System.out.println("messageType: " + request.headers().get("messageType"));
            System.out.println("businessType: " + request.headers().get("businessType"));

            // 可扩展：静态资源
            if ("/favicon.ico".equals(request.uri())) {
                return;
            }
            HttpMethod httpMethod = request.method();
            // 判断HttpHeader中是否包含Content-Length
            if (HttpMethod.POST.equals(httpMethod)) {
                if (HttpUtil.isContentLengthSet(request)) {
                    reader = new ByteBufToBytes((int) HttpUtil.getContentLength(request));
                }
            } else if (HttpMethod.GET.equals(httpMethod)) {
                FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                        Unpooled.wrappedBuffer("Welcome!!!".getBytes()));
                response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN); // HttpHeaders这个类中有这些常量，不过已经被废弃了
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
                response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
                ctx.write(response);
                ctx.flush();
            }
        }

        if (msg instanceof HttpContent) {
            HttpContent httpContent = (HttpContent) msg;
            ByteBuf content = httpContent.content();
            String result = "NA";

            if (content.readableBytes() > 0) {
                reader.reading(content);
                content.release();
                if (reader.isEnd()) {
                    result = new String(reader.readFull());
                    System.out.println("Client said: " + result);
                }
            }

            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(result.getBytes()));
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN);
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            ctx.write(response);
            ctx.flush();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
