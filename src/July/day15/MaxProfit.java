package July.day15;

/**
 * @题目 ：121. 买卖股票的最佳时机
 * @Data: 19/7/18
 * @题目描述： 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * @示例 1：###
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * @示例 2: ###
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 **/

public class MaxProfit {
    //暴力法
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                    profit[j] = Math.max(prices[i], profit[j]);
            }
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            maxProfit = Math.max(maxProfit, profit[i] - prices[i]);
        return maxProfit < 0 ? 0 : maxProfit;
    }
    //一次遍历写法==》添加两个辅助变量，时间复杂度大大降低
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


}
