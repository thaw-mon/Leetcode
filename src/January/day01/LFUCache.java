package January.day01;

/**
 * @题目 ：460. LFU Cache
 * @Data 20/01/02
 * @题目描述： Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 *
 *  
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 *
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/lfu-cache
 * @示例1: ######
 *
 * @示例2: ######
 * @示例3: ###
 */

import sun.awt.AWTAccessor;

import java.util.*;

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
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));// 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));//  // 返回 3
        cache.put(4, 4);    // 去除 key 1(不是替换3啊)
        System.out.println(cache.get(1)); // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));  // 返回 3
        System.out.println(cache.get(4));// 返回 4
    }

    class Info{
        Info(){
            key = -1;
            value = -1;
            frequent = 0;
        }
        Info(int k,int v, int f){
            key = k;
           value = v;
           frequent = f;
        }
        public int key;
        public int value;
        public int frequent;
    }

    Map<Integer,Integer> cache;  // key : pageKey
    Map<Integer,List<Integer>> frequent;  //保存key = 频率信息 value = 页信息(可以考虑改为优先队列)
    Info[] page; //指示页(存放了value，frequent信息)
    int size; //定义元素的大小
    int index; //指示使用页面的信息
    //先按照频率排序，频率相同，按照使用时间排序
    public LFUCache(int capacity) {
        index = 0;
        size = capacity;
        page = new Info[capacity];
        cache = new HashMap<>();
        frequent = new TreeMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        int pageNum = cache.get(key);
        int preFrequent = page[pageNum].frequent++;
        frequent.get(preFrequent).remove((Integer) pageNum);
        if(frequent.get(preFrequent).isEmpty()) frequent.remove(preFrequent);

        if(!frequent.containsKey(preFrequent+1)) frequent.put(preFrequent+1,new ArrayList<>());
        frequent.get(preFrequent+1).add(pageNum);
        return page[pageNum].value;
    }

    public void put(int key, int value) {

        if(cache.containsKey(key) || index < size){
            int pageNum = cache.getOrDefault(key,index);
            int preFrequent = -1; //获得频率的信息
            if(pageNum == index){ //使用了新的页面
                page[pageNum] = new Info(key,value,0);
                index++;
            }else {
                preFrequent = page[pageNum].frequent;
                page[pageNum].key = key;
                page[pageNum].value = value;
                page[pageNum].frequent = 0;
            }
            cache.put(key,pageNum);

            //修改频率信息
            if(frequent.containsKey(preFrequent)){
                frequent.get(preFrequent).remove((Integer)pageNum);
                if(frequent.get(preFrequent).isEmpty()) frequent.remove(preFrequent);
            }

            if(!frequent.containsKey(0)) frequent.put(0,new ArrayList<>());
            frequent.get(0).add(pageNum);
            return;
        }
        //替换LRU页面:找到frequent最小的节点
        Iterator<Integer> it = frequent.keySet().iterator();
        if(it.hasNext()){
            Integer k = it.next();
            List<Integer> list = frequent.get(k);
            int pageNum = list.get(0); //获取最近最少使用的pageNum
            list.remove(0);
            if(list.isEmpty()) frequent.remove(k);
            //把page内容替换
            int preKey = page[pageNum].key;
            page[pageNum].key = key;
            page[pageNum].value = value;
            page[pageNum].frequent = 0;
            if(!frequent.containsKey(0)) frequent.put(0,new ArrayList<>());
            frequent.get(0).add(pageNum);
            cache.remove(preKey); //删除之前的映射。
            cache.put(key,pageNum);
        }
    }
}
