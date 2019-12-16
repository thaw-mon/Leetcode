package July.day01;

/**
 * @题目 ：62. 不同路径
 * @题目描述： 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @Date:19/7/1
 * @示例 1: 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * @示例 2: 输入: m = 7, n = 3
 * 输出: 28
 **/

public class UniquePaths {

    public static void main(String[] args) {
        int m = 100;
        int n = 100;
        System.out.println(new UniquePaths().uniquePaths(m, n));
    }

    //easy : CombineTwoTables(N-1,M-1+N-1)
    //TODO  m==100 n==100会产生溢出问题
    public int uniquePaths(int m, int n) {
//        if (m == 1 || n == 1) return 1;
        int all = m + n - 2;
        int c = m > n ? n - 1 : m - 1;
        long res = 1;
        for (int i = 1; i <= c; i++) {
            res *= all--;
            res /= i;
        }

        return (int)res;
    }
    //动态规划思想
    //返回值为int就无法解决溢出问题
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
