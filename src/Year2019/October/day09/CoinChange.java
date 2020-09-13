package Year2019.October.day09;

import java.util.Arrays;

/**
 * @题目 ： 322. Coin Change
 * @Data 19/10/17
 * @题目描述： You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * @示例1: ######
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * @示例2: ######
 * Input: coins = [2], amount = 3
 * Output: -1
 * @示例3: ###
 */

public class CoinChange {

    public static void main(String[] args) {
        //[288,160,10,249,40,77,314,429]
        //9208
        //[456,117,5,145]
        //1459
        int[] coins = {456,117,5,145};
        int amount = 1459;
        System.out.println(new CoinChange().coinChange2(coins, amount));
    }

    int res = Integer.MAX_VALUE;

    //贪心算法可以获得解，但是不一定是最优解,因此找到解后还需要继续查看是否有更优解
    //结果超时了-->需要改为动态规划写法
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //排好序
        Arrays.sort(coins);
        helper(coins, amount, n - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private boolean helper(int[] coins, int amount, int n, int num) {
        //剪枝操作
        if (num >= res)
            return false;
        if (amount == 0) {
            res = Math.min(res, num);
            return true;
        }
        for (int i = n; i >= 0; i--) {
            int k = amount / coins[i];
            for (int j = k; j > 0; j--) {
                if (helper(coins, amount - coins[i] * j, i - 1, num + j))
                    break;
            }
        }
        return false;
    }

    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
//        Arrays.sort(coins);
        //打补丁:amount==0情形
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount; i++) {
            if (i == 0 || dp[i] > 0)
                updateDp(coins, i, amount, dp);
            if (dp[amount] > 0)
                System.out.println(dp[amount]);
        }
        return dp[amount] > 0 ? dp[amount] : -1;
    }

    //[1,2147483647]
    //2
    private void updateDp(int[] coins, int i, int amount, int[] dp) {
        int n = coins.length;
        for (int j = 0; j < n; j++) {
            //防止溢出
            if (Integer.MAX_VALUE - i < coins[j])
                continue;
            int k = i + coins[j];
            if (k <= amount) {
                dp[k] = (dp[k] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[k]);
            }
        }
    }
}
