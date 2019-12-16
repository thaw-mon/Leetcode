package September.day03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @题目 ： 217. Contains Duplicate
 * @Data 19/9/04
 * @题目描述： Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * @题目地址： 链接：https://leetcode-cn.com/problems/contains-duplicate
 * @示例1: ######
 * Input: [1,2,3,1]
 * Output: true
 * @示例2: ###
 * Input: [1,2,3,4]
 * Output: false
 * @示例3: ###
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

public class ContainsDuplicate {
    //转换为set判断
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num))
                return true;
            numSet.add(num);
        }
        return false;
    }
}
