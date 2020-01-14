package com.zhonghuasheng.designpattern.reactor;

/**
 * 外部输入类。用来表示需要reactor去处理的原始对象
 */
public class InputSource {

    private Object data;
    private long id;

    public InputSource(Object data, long id) {
        this.data = data;
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InputSource{" +
                "data=" + data +
                ", id=" + id +
                '}';
    }
}
