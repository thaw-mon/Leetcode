package Year2020.July.day02;

/**
 * @Title : 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @Date : 2020/07/05
 * @思路 ：n 比较小可以采用动态规划
 */
public class Demo02 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        //dp[i] = Math.max(dp[i-k] * dp[k]);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[j], j) * Math.max(dp[i - j], i - j), dp[i]);
            }
        }
        return dp[n];
    }
}
