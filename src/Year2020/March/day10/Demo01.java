package Year2020.March.day10;

public class Demo01 {

    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
     * 返回你可以获得的最大乘积。
     * 做过的题目
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        //动态规划解法
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }
        return dp[n];
    }
}
