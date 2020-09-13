package Year2019.November.day03;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ： 350. Intersection of Two Arrays II
 * @Data 19/11/10
 * @题目描述： Given two arrays, write a function to compute their intersection.
 * @题目链接： 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @示例1: ######
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * @示例2: ######
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * @示例3: ###
 */

public class IntersectionTwoArraysII {
    //这道题不能直接使用set,因为要输出交集的次数：改用map
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int value = Math.min(map1.get(key), map2.get(key));
                for (int i = 0; i < value; i++)
                    res[index++] = key;
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++)
            result[i] = res[i];
        return result;
    }
}
