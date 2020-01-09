package com.zhonghuasheng.netty.tcp.protocol;

public class TcpProtocol {

    private byte header=0x58;
    private int length;
    private byte[] data;
    private byte end=0x63;

    public byte getHeader() {
        return header;
    }

    public void setHeader(byte header) {
        this.header = header;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getEnd() {
        return end;
    }

    public void setEnd(byte end) {
        this.end = end;
    }
}
