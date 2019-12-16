package November.day08;

import java.util.*;

/**
 * @题目 ： 380. Insert Delete GetRandom O(1)
 * @Data 19/11/19
 * @题目描述： GDesign a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * @题目链接： 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
 * @示例1: ######
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * @示例2: ######
 * @示例3: ###
 */

//作者：1-12-14-18
//        链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1/solution/li-yong-hashmaphe-arraylistshi-xian-by-1-12-14-18/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class RandomizedSet {

    //插入删除要保持O(1):
    private List<Integer> list;
    private Map<Integer,Integer> map;
    int size;
    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        size = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        //在ArrayList末尾添加一个数的时间复杂度为O(1)
        map.put(val, list.size());
        list.add(val);
        size++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        int index, num;

        if(!map.containsKey(val))
            return false;
        //由于在ArrayList中间删除一个元素的时间复杂度为O(N)
        //因此用末尾的数替换掉需要删除的数(根据map得到索引,平均时间复杂度O(1))
        //再删除掉末尾的数(时间复杂度O(1))
        index = map.get(val);
        num = list.get(size - 1);
        list.set(index, num);
        map.put(num, index);
        map.remove(val);
        list.remove(size - 1);
        size--;
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index;

        //ArrayList根据索引访问时间复杂度为O(1)
        index = (int)(size * Math.random());
        return list.get(index);
    }
}
