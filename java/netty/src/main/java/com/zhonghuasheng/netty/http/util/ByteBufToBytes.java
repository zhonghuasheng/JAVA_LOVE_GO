package com.zhonghuasheng.netty.http.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufToBytes {

    private ByteBuf temp;
    private boolean end = true;

    public ByteBufToBytes(int length) {
        // Pooled和Unpooled：pooled类型的bytebuf是在已经申请好的内存块取一块内存，而Unpooled是直接通过JDK底层代码申请。
        temp = Unpooled.buffer(length);
    }

    public void reading(ByteBuf datas) {
        datas.readBytes(temp, datas.readableBytes());
        if (this.temp.writableBytes() != 0) {
            end = false;
        } else {
            end = true;
        }
    }

    public byte[] readFull() {
        if (end) {
            byte[] contentByte = new byte[this.temp.readableBytes()];
            this.temp.readBytes(contentByte);
            this.temp.release();
            return contentByte;
        } else {
            return null;
        }
    }

    public byte[] read(ByteBuf datas) {
        byte[] bytes = new byte[datas.readableBytes()];
        datas.readBytes(bytes);
        return bytes;
    }

    public boolean isEnd() {
        return end;
    }
}
