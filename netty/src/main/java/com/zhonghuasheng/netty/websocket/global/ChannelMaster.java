package com.zhonghuasheng.netty.websocket.global;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ConcurrentHashMap;

public class ChannelMaster {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private static ConcurrentHashMap<String, ChannelId> channelMap = new ConcurrentHashMap<>();

    public static void addChannel(Channel channel) {
        channelGroup.add(channel);
        channelMap.put(channel.id().asLongText(), channel.id());
    }

    public static void removeChannel(Channel channel) {
        channelGroup.remove(channel);
        channelMap.remove(channel.id().asLongText());
    }

    public static Channel findChannel(String channelId) {
        return channelGroup.find(channelMap.get(channelId));
    }

    public static void send2All(TextWebSocketFrame tws) {
        channelGroup.writeAndFlush(tws);
    }
}
