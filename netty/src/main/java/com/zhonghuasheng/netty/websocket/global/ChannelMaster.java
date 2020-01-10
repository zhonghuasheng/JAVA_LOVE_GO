package com.zhonghuasheng.netty.websocket.global;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;

public class ChannelMaster {

    private static final Logger logger = Logger.getLogger(ChannelMaster.class);
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private static ConcurrentHashMap<String, ChannelId> channelMap = new ConcurrentHashMap<String, ChannelId>();

    public static void addChannel(Channel channel) {
        channelGroup.add(channel);
        channelMap.put(channel.id().asShortText(), channel.id());
    }

    public static void removeChannel(Channel channel) {
        channelGroup.remove(channel);
        channelMap.remove(channel.id().asShortText());
    }

    public static Channel findChannel(String channelId) {
        return channelGroup.find(channelMap.get(channelId));
    }

    public static void send2All(TextWebSocketFrame tws) {
        channelGroup.writeAndFlush(tws);
    }

    public static void send(String channelId, TextWebSocketFrame tws) {
        Channel channel = findChannel(channelId);
        if (channel != null) {
            channel.writeAndFlush(tws);
        } else {
            logger.info(String.format("%s Channel不存在", channelId));
        }
    }
}
