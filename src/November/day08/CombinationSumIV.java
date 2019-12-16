package November.day08;

/**
 * @题目 ： 377. Combination Sum IV
 * @Data 19/11/19
 * @题目描述： Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * @题目链接： 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * @示例1: ######
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * Note that different sequences are counted as different combinations.
 * <p>
 * Therefore the output is 7.
 * @示例2: ######
 * @示例3: ###
 */
public class CombinationSumIV {


    //动态规划或深度优先算法
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
