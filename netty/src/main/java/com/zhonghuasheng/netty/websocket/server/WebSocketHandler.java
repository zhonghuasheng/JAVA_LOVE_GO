package com.zhonghuasheng.netty.websocket.server;

import com.zhonghuasheng.netty.websocket.global.ChannelMaster;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.*;
import org.apache.log4j.Logger;

public class WebSocketHandler extends SimpleChannelInboundHandler<Object> {

    private final Logger logger = Logger.getLogger(this.getClass());
    private WebSocketServerHandshaker webSocketServerHandshaker;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(channelHandlerContext, (FullHttpRequest) msg);
        } else {
            handleWebSocketFrame(channelHandlerContext, (WebSocketFrame) msg);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        String msg = ((TextWebSocketFrame) frame).text();
        logger.info(String.format("服务端收到：{}， 消息来自{}", msg, ctx.channel().id().asShortText()));
        TextWebSocketFrame tws = new TextWebSocketFrame("群发消息");
        ChannelMaster.send2All(tws);
    }

    // WebScoket的首次请求为Http请求，用于达成握手成功
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
        // 拒绝不合理请求
        if (!request.decoderResult().isSuccess() || !"websocket".equals(request.headers().get("Upgrade"))) {
            // 返回消息
            return;
        }

        // String webSocketURL, String subprotocols, boolean allowExtensions
        WebSocketServerHandshakerFactory webSocketServerHandshakerFactory = new WebSocketServerHandshakerFactory(
                "ws://localhost:8002/websocket", null, false);
        webSocketServerHandshaker = webSocketServerHandshakerFactory.newHandshaker(request);

        if (webSocketServerHandshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            webSocketServerHandshaker.handshake(ctx.channel(), request);
        }
    }

    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("Registered");
    }

    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("Unregistered");
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Active");
        ChannelMaster.addChannel(ctx.channel());
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Inactive");
        ChannelMaster.removeChannel(ctx.channel());
    }
}
