package Year2020.March.day06;

public class Demo02 {

    /**
     * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {

        //获得最长回文子序列 dp方法 dp[i][j] 第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
        //
        char[] array = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                if (k == 0) dp[i][i + k] = 1;
                else {
                    if(array[i]==array[i+k])
                        dp[i][i+k] = 2 + dp[i+1][i+k-1];
                    else
                        dp[i][i+k] = Math.max(dp[i][i+k-1],dp[i+1][i+k]);
                }
            }
        }

        return dp[0][n-1];
    }
}
