package com.zhonghuasheng.netty.websocket.server;

import com.alibaba.fastjson.JSON;
import com.zhonghuasheng.netty.websocket.global.ChannelMaster;
import com.zhonghuasheng.netty.websocket.global.MessagePacket;
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
        // 关闭连接
        if (frame instanceof CloseWebSocketFrame) {
            webSocketServerHandshaker.close(ctx.channel(), ((CloseWebSocketFrame) frame).retain());
            logger.info(String.format("%s与WebSocketServer连接关闭", ctx.channel().id().asShortText()));
        }

        String msg = ((TextWebSocketFrame) frame).text();
        MessagePacket messagePacket = JSON.parseObject(msg, MessagePacket.class);
        logger.info(String.format("服务端收到：消息来自%s，要发送到%s", messagePacket.getFromChannelId(), messagePacket.getToChannelId()));
        TextWebSocketFrame tws = new TextWebSocketFrame(messagePacket.getMessage());
        ChannelMaster.send(messagePacket.getToChannelId(), tws);
        // 群发
        // ChannelMaster.send2All(tws);
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
        logger.info(String.format("Active: %s", ctx.channel().id().asShortText()));
        ChannelMaster.addChannel(ctx.channel());
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Inactive");
        ChannelMaster.removeChannel(ctx.channel());
    }
}
