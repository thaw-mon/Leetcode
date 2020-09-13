package Year2020.March.day11;

public class Demo02 {

    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {

        //动态规划思路:很难找到规律啊
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - 1 - j];
        }
        return dp[n];
    }
}
