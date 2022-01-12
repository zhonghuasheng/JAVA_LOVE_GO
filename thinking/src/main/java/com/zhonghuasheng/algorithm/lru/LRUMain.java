package com.zhonghuasheng.algorithm.lru;

/**
 * @description LRU算法测试
 */
public class LRUMain {

    public static void main(String[] args) {
        // 初始化容量为3的LRU
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        // 设置4，4，结果为2，3，4
        lruCache.set(4, 4);
        // get 2，结果为3，4，2
        Node node = lruCache.get(2);
        System.out.println(node.value);
        Node node2 = lruCache.get(2);
        System.out.println(node2.value);
    }
}
