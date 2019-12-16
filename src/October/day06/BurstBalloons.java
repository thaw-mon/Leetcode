package October.day06;

/**
 * @题目 ： 312. Burst Balloons
 * @Data 19/10/13
 * @题目描述： Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * @题目地址： 链接：https://leetcode-cn.com/problems/burst-balloons
 * @示例1: ######
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @示例2: ######
 * @示例3: ###
 */

public class BurstBalloons {

    public static void main(String[] args){
        int[] nums = {3,1,5,8};
        System.out.println(new BurstBalloons().maxCoins(nums));
    }

    //1. 暴力法:每次爆掉一个球 需要 n!时间复杂度--->超时
    //2. 动态规划思想 :
// 作者：pphdsny
// 链接：https://leetcode-cn.com/problems/burst-balloons/solution/312-chuo-qi-qiu-java-dong-tai-gui-hua-by-pphdsny/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];

        int[] newNums = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[0] = 1;
        newNums[n + 1] = 1;

        for (int j = 2; j < newNums.length; j++) {
            //遍历所有的可能性
            for (int i = 0; i < newNums.length - j; i++) {

                for (int k = i + 1; k < i + j; k++) {
                    //最后爆破k号气球
                    dp[i][i + j] = Math.max(dp[i][i + j], dp[i][k] + dp[k][i + j] + newNums[i] * newNums[k] * newNums[i + j]);
                }
            }
        }
        return dp[0][newNums.length - 1];
    }
}
