package Year2019.September.day04;

import java.util.*;

/**
 * @题目 ： 218. Contains Duplicate III
 * @Data 19/9/05
 * @题目描述： Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * @题目地址： 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * @示例1: ######
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * @示例2: ###
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * @示例3: ###
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */

public class ContainsDuplicateIII {
    //注意[0,2147483647] 1 2147483647 会超时 -->采用二分法
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //居然存在 t < 0 用例
        if (t < 0) return false;
        //t == 0 退化为 II的问题了,直接copy
        if (t == 0) return helper(nums, k);
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int left, right, len;
        for (int i = 0; i < n; i++) {
            //防止溢出问题
            left = nums[i] < (t + Integer.MIN_VALUE) ? Integer.MIN_VALUE : nums[i] - t;
            right = (Integer.MAX_VALUE - t) < nums[i] ? Integer.MAX_VALUE : nums[i] + t;

            //判断set中是否存在val 在 left- right之间
            if (isContain(new ArrayList<>(set), left, right))
                return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    //前一道题II的代码，直接粘贴过来了
    public boolean helper(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    //二分法：判断set是否存在value 在lNum - rNum之间
    private boolean isContain(List<Integer> list, int lNum, int rNum) {
        int n = list.size();
        int l = 0, r = n - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (list.get(mid) < lNum) {
                l = mid + 1;
            } else if (list.get(mid) > rNum)
                r = mid - 1;
            else
                return true;
        }
        return false;
    }


}
