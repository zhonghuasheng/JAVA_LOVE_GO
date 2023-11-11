package com.zhonghuasheng.netty.websocket.global;

import com.alibaba.fastjson.annotation.JSONField;

public class MessagePacket {

    @JSONField(name = "from")
    private String fromChannelId;

    @JSONField(name = "to")
    private String toChannelId;

    @JSONField(name = "msg")
    private String message;

    public MessagePacket(String fromChannelId, String toChannelId, String message) {
        this.fromChannelId = fromChannelId;
        this.toChannelId = toChannelId;
        this.message = message;
    }

    public String getFromChannelId() {
        return fromChannelId;
    }

    public void setFromChannelId(String fromChannelId) {
        this.fromChannelId = fromChannelId;
    }

    public String getToChannelId() {
        return toChannelId;
    }

    public void setToChannelId(String toChannelId) {
        this.toChannelId = toChannelId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
