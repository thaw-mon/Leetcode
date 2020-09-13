package Year2020.January.day01;

import java.util.*;

/**
 * @题目 ：460. LFU Cache
 * @Data 20/01/02
 * @题目描述： Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * @Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * @题目链接： 链接：https://leetcode-cn.com/problems/lfu-cache
 * @示例1: ######
 *
 * @示例2: ######
 * @示例3: ###
 */



/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LFUCache {
//    ["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
//[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
    public static void main(String[] args){
        LFUCache cache = new LFUCache( 10 /* capacity (缓存容量) */ );
        cache.put(10,13); cache.put(3,17); cache.put(6,11); cache.put(10,5); cache.put(9,10);
        System.out.println(cache.get(13));
        cache.put(2,19);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(5,25);
        System.out.println(cache.get(8));
        cache.put(9,22); cache.put(5,5); cache.put(1,30);
        System.out.println(cache.get(11));
        cache.put(9,12);
        System.out.println(cache.get(7));System.out.println(cache.get(5));System.out.println(cache.get(8));System.out.println(cache.get(9));
        cache.put(4, 30);     cache.put(9, 3);
        System.out.println(cache.get(9));System.out.println(cache.get(10));System.out.println(cache.get(10));
        cache.put(6,14);     cache.put(3,1);
        System.out.println(cache.get(3));
        cache.put(10,11);
        System.out.println(cache.get(8));
        cache.put(2,14);
        System.out.println(cache.get(1)); System.out.println(cache.get(5)); System.out.println(cache.get(4));
        cache.put(11,4); cache.put(12,24); cache.put(5,18);
        System.out.println(cache.get(13));
        cache.put(7,23);
        System.out.println(cache.get(8)); System.out.println(cache.get(12));
        cache.put(3,27); cache.put(2,12);
        System.out.println(cache.get(5));
        cache.put(2,9); cache.put(13,4); cache.put(8,18); cache.put(1,7);
        System.out.println(cache.get(6));
    }

    class Node{
        Node(){
            key = -1;
            value = -1;
            frequent = 0;
        }
        Node(int k,int v, int f){
            key = k;
            value = v;
            frequent = f;
        }
        public int key;
        public int value;
        public int frequent;
    }

    Map<Integer,Node> cache;  // key : pageKey
    Map<Integer,LinkedHashSet<Node>> frequent;  //保存key = 频率信息 value = 页信息(可以考虑改为优先队列)
    int size; //定义元素的大小
    int index; //指示使用页面的信息
    int min; //记录最小频率
    //先按照频率排序，频率相同，按照使用时间排序
    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        frequent = new HashMap<>();
        this.size = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        freqInc(node);
       return node.value;
    }

    public void put(int key, int value) {
        if (size == 0) {
            return;
        }

        Node node = cache.getOrDefault(key,null);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            //释放一个节点空间
            if (index == size) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                index--;
            }
            Node newNode = new Node(key, value,0);
            cache.put(key, newNode);
            addNode(newNode);
            index++;
        }
    }

    //功能：对节点的频率加1
    public void freqInc(Node node){
        int freq = node.frequent; //节点自身的频率++
        //删除原先频率所在的链表
        LinkedHashSet<Node> set = frequent.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.frequent++;
        if(!frequent.containsKey(freq+1)) frequent.put(freq+1,new LinkedHashSet<>());
        LinkedHashSet<Node> newSet = frequent.get(freq+1);
        newSet.add(node);
    }

    public void addNode(Node node){
        LinkedHashSet<Node> set = frequent.computeIfAbsent(0, k -> new LinkedHashSet<>());
        set.add(node);
        min = 0;
    }
    //删除最小频率所在的节点
    public Node removeNode(){
        LinkedHashSet<Node> set = frequent.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}
