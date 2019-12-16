package July.day03;

/**
 * @题目 ：72. 编辑距离
 * @题目描述： 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 1. 插入一个字符
 * 2. 删除一个字符
 * 3. 替换一个字符
 * @Date:19/7/3
 * @示例 1: 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * @示例 2: 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 **/

public class EditDistance {

    //一开始没想明白,看评论后发现还是一个动态规划问题]
    //dp[i][j] = min{ dp[i-1][j-1]+1/0 , dp[i-1][j] + 1 , dp[i][j-] + 1}
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                int flag = 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    flag = 0;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + flag);
            }
        return dp[m][n];
    }
    //大佬在内部的优化
//if (word1[i-1] == word2[j-1]) {
//                    cost[i][j] = cost[i-1][j-1];
//                } else {
//                    cost[i][j] = 1 + min(cost[i-1][j-1], min(cost[i][j-1], cost[i-1][j]));
//                }
}
