package November.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @题目 ： 368. Largest Divisible Subset
 * @Data 19/11/15
 * @题目描述： Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * <p>
 * Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * @题目链接： 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * @示例1: ######
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * @示例2: ######
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 * @示例3: ###
 */

public class LargestDivisibleSubset {
    //求最大整除集合
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //1.对数组排序
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] dp_seq = new int[nums.length];
        int max = -1, max_index = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    dp_seq[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                max_index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            res.add(0, nums[max_index]);
            max_index = dp_seq[max_index];
        }
        return res;
    }
}
