package Year2020.April.day05;

import java.util.HashSet;
import java.util.Set;

public class Demo03 {

    /**
     * 不使用任何内建的哈希表库设计一个哈希映射
     * 所有的值都在 [0, 1000000]的范围内。
     */
    class MyHashMap {

        int base;
        Integer[] bucket; //使用Integer是保证初始值为null
        Set<Integer> keys;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            base = 100; //初始长度设为100;
            bucket = new Integer[base];
            keys = new HashSet<>();
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            //重新构建数组，扩展数组长度
            while (key >= base) {
                base *= 2;
            }
            int len = bucket.length;
            if (base > len) {
                Integer[] tmp = new Integer[base];
                for (int k : keys) {
                    tmp[k] = bucket[k];
                }
                bucket = tmp;
            }
            keys.add(key);
            bucket[key] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            if (!keys.contains(key)) return -1;
            return bucket[key];
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            if (!keys.contains(key)) return;
            keys.remove(key);
            bucket[key] = null;
        }
    }

}
