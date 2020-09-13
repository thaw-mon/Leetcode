package Year2019.August.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：146. LRU缓存机制
 * @Data: 19/8/10
 * @题目描述： 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * @题目地址： https://leetcode-cn.com/problems/lru-cache/
 * @示例1: ######
 * LRUCache cache = new LRUCache( 2 // 缓存容量  );
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * @示例2: ###
 **/

//可以使用自带API
//有一种叫做有序字典的数据结构，综合了哈希表和链表，在 Python 中为 OrderedDict，在 Java 中为 LinkedHashMap。
public class LRUCache {
    public static void main(String[] args) {

        Map<Integer, Integer> demo = new HashMap<>();
        demo.put(1, 1);
        demo.put(2, 2);
        demo.remove(1);


        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    //增加一个节点到头节点
    private void AddNode(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    //删除一个节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        AddNode(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private Map<Integer, DLinkedNode> cache;
    private int capacity;
    private int size;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;

        //初始化头部和尾部
        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        //没有该节点
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            //将节点加入List
            AddNode(newNode);
            size++;
            cache.put(key, newNode);

            //数量超了 删除最后一个节点
            if (size > capacity) {
                DLinkedNode lastNode = removeTail();
                cache.remove(lastNode.key);
                size--;
            }

        }else {
            //更新节点
            node.value = value;
            moveToHead(node);
        }
    }
}
