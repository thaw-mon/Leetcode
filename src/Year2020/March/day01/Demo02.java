package Year2020.March.day01;

public class Demo02 {

    /**
     * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
     * 1. 打印机每次只能打印同一个字符序列。
     * 2. 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
     * @param s : 只包含小写英文字母的字符串
     * @return : 这个打印机打印它需要的最少次数。
     */
//      作者：LeetCode
//    链接：https://leetcode-cn.com/problems/strange-printer/solution/qi-guai-de-da-yin-ji-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int[][] memo;
    public int strangePrinter(String s) {
        //思路 ：动态规划 dp[i][j] : 打印 [i,j]需要的次数

        int N = s.length();
        memo = new int[N][N];

        return dp(s, 0, N - 1);

    }
    public int dp(String s, int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] == 0) {
            int ans = dp(s, i+1, j) + 1;
            for (int k = i+1; k <= j; ++k)
                if (s.charAt(k) == s.charAt(i))
                    ans = Math.min(ans, dp(s, i, k-1) + dp(s, k+1, j));
            memo[i][j] = ans;
        }
        return memo[i][j];
    }


}
