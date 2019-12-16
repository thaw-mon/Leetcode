package July.day14;

/**
 * @题目 ：115. 不同的子序列
 * @Data: 19/7/17
 * @题目描述： 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * @示例 1：
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 * <p>
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * <p>
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * @示例 2: ###
 * 输入: S = "babgbag", T = "bag"
 * 输出: 5
 * 解释:
 * <p>
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * <p>
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 **/

public class DistinctSubsequences {

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
//        System.out.println(t.indexOf('0'));
        System.out.println(new DistinctSubsequences().numDistinct(s, t));
        System.out.println(new DistinctSubsequences().numDistinct2(s, t));
        System.out.println(new DistinctSubsequences().numDistinct3(s, t));
    }

    //无脑递归写法-->超时了
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        //子串小于主串
        if (n < m) return 0;
        //两串相等
        if (m == n) return s.equals(t) ? 1 : 0;
        //t为空串情形
        if (m == 0) return 1;
        int size = 0;

        for (int i = 0; i < n; i++)
            if (s.charAt(i) == t.charAt(0))
                if (m == 1) size += 1;
                else
                    size += numDistinct(s.substring(i + 1), t.substring(1));
        return size;
    }

    //动态规划写法 ==>二维数组写法
    public int numDistinct2(String s, String t) {
        int m = s.length();
        int n = t.length();
        //m==0 || n==0
        //m=0,n=0 1  m=0,n！=0 0 m!=0 n=0 1
        if (m == 0 || n == 0)
            return n == 0 ? 1 : 0;

        //dp[i][j] = 表示 s[:i] 和 t[:j]匹配的数量
        //dp[i][j] = dp[i-1][j] + s[i]==s[j]?dp[i-1][j-1]:0
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] += dp[i - 1][j - 1];
            }
        return dp[m][n];
    }

    //动态规划 ==>简化一维数组写法
    public int numDistinct3(String s, String t) {
        int m = s.length();
        int n = t.length();
        //m==0 || n==0
        //m=0,n=0 1  m=0,n！=0 0 m!=0 n=0 1
        if (m == 0 || n == 0)
            return n == 0 ? 1 : 0;

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[j] += dp[j-1];
            }
        return dp[n];
    }

}
