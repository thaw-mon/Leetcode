package October.day05;

/**
 * @题目 ： 309. Best Time to Buy and Sell Stock with Cooldown
 * @Data 19/10/11
 * @题目描述： Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * @题目地址： 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * @示例1: ######
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * @示例2: ######
 * @示例3: ###
 */

public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        int[] prices = {1,4,2};
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp[i][k]表示第i天 k(0未持有股票,1持有股票)状态下的利润
        //存在一天冷冻期
        //dp[i][0] =max(dp[i-1][0],dp[i-1][1] + price[i])
        //dp[i][1] = max(dp[i-1][1],dp[i-2][0] - price[i])
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
