package com.zhonghuasheng.algorithm.lru;

import java.util.HashMap;

/**
 * @author Luke Chen
 * @description LRU算法实现类
 * @date 2022/1/12
 **/
public class LRUCache {

    /**
     * LRU缓存容量
     */
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    /**
     * 头节点：最近使用的节点
     */
    Node head = new Node();
    /**
     * 尾节点：最少使用的节点
     */
    Node end = new Node();

    /**
     * 构造函数
     * @param capacity 缓存容量
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 通过key获取节点
     * @param key
     * @return
     */
    public Node get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            this.remove(node);
            this.moveToHead(node);
            return node;
        }
        return null;
    }

    /**
     * 移除节点node的前驱和后驱关系
     * @param node
     */
    private void remove(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            end = node.pre;
        }
    }

    /**
     * 设置头节点和尾节点
     * @param node
     */
    private void moveToHead(Node node) {
        // 新节点前驱为head
        node.pre = head;
        if (this.head.next != null) {
            Node secondNode = head.next;
            secondNode.pre = node;
            node.next = secondNode;
        }
        head.next = node;
        if (this.end.pre == null) {
            this.end.pre = node;
            node.next = end;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            oldNode.value = value;
            this.remove(oldNode);
            this.moveToHead(oldNode);
        } else {
            Node newNode = new Node(key, value);
            // 超过LRU缓存大小，移除尾节点
            if (map.size() >= capacity) {
                map.remove(end.pre.key);
                this.remove(end.pre);
            }
            this.moveToHead(newNode);
            this.map.put(key, newNode);
        }
    }
}
