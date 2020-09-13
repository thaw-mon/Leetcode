package Year2019.August.day13;

/**
 * @题目 ：187. Repeated DNA Sequences
 * @Data 19/8/21
 * @题目描述： Say you have an array for which the i-th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * @题目地址： 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * @Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @示例1: ######
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * @示例2: ###
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * @示例3: ###
 */

public class BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};

        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2)
            return maxProfit_k_inf(prices);

        int[][][] dp = new int[n][k+1][2];

        //第一维度表示天数,第二维度表示交易次数 第三维度表示是否持有股票 0表示未持有股票 1表示持有股票
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                //第一次交易判断
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                //第i天第j次交易 没有股票()
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                //第i天第j次交易 持有股票()
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }

        }
        return dp[n - 1][k][0];
    }

    //      作者：labuladong
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-w-5/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // k 为任意次数
    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
