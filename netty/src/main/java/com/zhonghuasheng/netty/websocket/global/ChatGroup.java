package com.zhonghuasheng.netty.websocket.global;

import io.netty.channel.group.ChannelGroup;

import java.util.concurrent.ConcurrentHashMap;

public class ChatGroup {

    public static ConcurrentHashMap<String, ChannelGroup> chatGroup = new ConcurrentHashMap<>();
}
