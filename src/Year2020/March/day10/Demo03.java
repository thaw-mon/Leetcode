package Year2020.March.day10;

public class Demo03 {

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //求最长公共子序列
        int l1 = text1.length(), l2 = text2.length();
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int[][] dp = new int[l1 + 1][l2 + 1];  //dp[i][j]表示text的前i个字符和dp[j]的前j个字符的最长公共子序列长度
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                //判定i和j是否为相同字符
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[l1][l2];
    }
}
