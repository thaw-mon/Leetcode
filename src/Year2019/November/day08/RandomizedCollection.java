package Year2019.November.day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @题目 ： 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * @Data 19/11/19
 * @题目描述： Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * @题目链接： 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * @示例1: ######
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * <p>
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * <p>
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * <p>
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * <p>
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * <p>
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 * @示例2: ######
 * @示例3: ###
 */

//和前面的差别是允许重复
public class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, List<Integer>> map;
    int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        size = 0;
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean flag = true;
        if (map.containsKey(val))
            flag = false;
        //val不存在
        if (flag) {
            map.put(val, new ArrayList<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        size++;
        return flag;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        int index, num;

        if (!map.containsKey(val))
            return false;
        int s = map.get(val).size() - 1;
        //获取map最后一个val在list的位置
        index = map.get(val).get(s);
        //获取list最后一个元素
        num = list.get(size - 1);

        list.set(index, num);
        //获取list最后一个元素对于map的索引
        int s1 = map.get(num).indexOf(size - 1);

        map.get(num).set(s1, index);

        map.get(val).remove(s);
        if (map.get(val).isEmpty())
            map.remove(val);
        list.remove(size - 1);
        size--;
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int index;

        //ArrayList根据索引访问时间复杂度为O(1)
        index = (int)(size * Math.random());
        return list.get(index);
    }

}
