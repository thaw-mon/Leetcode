package December.day05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @题目 ：416. Partition Equal Subset Sum
 * @Data 19/12/10
 * @题目描述： Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * <p>
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * @题目链接： 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * @示例1: ######
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * @示例2: ######
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * @示例3: ###
 */

public class PartitionEqualSubsetSum {
    public static void main(String[] args){
        int[] nums = {2,2,3,5};
        System.out.println(new PartitionEqualSubsetSum().canPartition2(nums));
    }
    //把数组分为两部分使得二者相等:显然和必须是偶数
    //使用队列（超时了）
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        //1.判断是否是偶数
        if (sum % 2 == 1) return false;
        //2.判断是否存在子集使得 ans = sum / 2
        int ans = sum / 2;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int i = 0; i < nums.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int val = queue.poll();
                if (val + nums[i] == ans) return true;
                queue.add(val);
                queue.add(val + nums[i]);
            }
        }
        return false;
    }

    //2.动态规划思路
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        //1.判断是否是偶数
        if (sum % 2 == 1) return false;
        //2.判断是否存在子集使得 ans = sum / 2
        int ans = sum / 2;
        boolean[] dp = new boolean[ans + 1];
        dp[0] = true;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            //这里要逆序，否则会出错 2,2,3,5
            for (int j = Math.min(ans, preSum); j >= nums[i]; j--) {
                if (!dp[j] && dp[j - nums[i]]) dp[j] = true;
            }
        }
        return dp[ans];
    }
}
