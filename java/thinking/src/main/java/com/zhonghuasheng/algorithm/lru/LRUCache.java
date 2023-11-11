package com.zhonghuasheng.algorithm.lru;

import java.util.HashMap;

/**
 * @author Luke Chen
 * @description LRU算法实现类
 * LRU Last Recently Used 最近最少使用算法，顾名思义就是最近不常用的要被移除掉，常用于淘汰机制。
 * 算法实现逻辑： 使用双向链表来存储数据【解决插入和删除的时间复杂度，内存空间不需要连续】，定义一个HashMap来存储Key到Node的映射，
 *             实现O(1)复杂度的查找节点，定义一个int类型的capacity，用于控制LRU的容量。定义一个head和end节点，Node类中的属性直接定义
 *             不写get/set，否则toString的时候会报sof。head <-> Node1 <-> Node2 <-> Node3 <-> end
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
        node.pre.next = node.next;
        node.next.pre = node.pre;
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
