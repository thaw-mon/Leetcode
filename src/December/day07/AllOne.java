package December.day07;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @题目 ：432. All O`one Data Structure
 * @Data 19/12/16
 * @题目描述： Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 * @题目链接： 链接：https://leetcode-cn.com/problems/all-oone-data-structure
 * @示例1: ######
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * @示例2: ######
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * @示例3: ###
 * Input: head = []
 * Output: []
 */

public class AllOne {

    Map<String, Integer> maps;


    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        maps = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        int value = maps.getOrDefault(key, 0) + 1;
        maps.put(key, value);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (maps.containsKey(key)) {
            int value = maps.getOrDefault(key, 0) - 1;
            if (value <= 0) maps.remove(key);
            else maps.put(key, value);
        }

    }

    /**
     * Returns one of the keys with maximal value.
     */
    //获取最大value对应的key:如何实现O(1)?
    //TODO 要实现O(1):需要使用双向链表维护最大最小值
    public String getMaxKey() {
        if(maps.isEmpty()) return "";
        //偷个懒：直接使用遍历法
        String res = ""; int value =0;
        for(String s: maps.keySet()){
            if(maps.get(s) > value){
                res = s;
                value = maps.get(s);
            }
        }
        return res;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if(maps.isEmpty()) return "";
        //偷个懒：直接使用遍历法
        String res = ""; int value = Integer.MAX_VALUE;
        for(String s: maps.keySet()){
            if(maps.get(s) < value){
                res = s;
                value = maps.get(s);
            }
        }
        return res;
    }
}
