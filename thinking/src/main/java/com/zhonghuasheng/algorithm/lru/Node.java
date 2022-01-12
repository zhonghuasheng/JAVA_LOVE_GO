package com.zhonghuasheng.algorithm.lru;

import lombok.Data;

/**
 * @author Luke Chen
 * @description 链表节点类
 * @date 2022/1/12
 **/
public class Node {
    /**
     * 节点key
     */
    protected Integer key;
    /**
     * 节点value
     */
    protected Object value;
    /**
     * 前驱节点
     */
    protected Node pre;
    /**
     * 后驱节点
     */
    protected Node next;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
