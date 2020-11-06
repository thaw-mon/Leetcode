package Year2020.November.day05;

import java.util.Scanner;

public class Demo06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(countPlace(m, n));
        }
        scanner.close();
    }

    /**
     * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
     */

    public static int countPlace(int m, int n) {
        if (m == 0) return 1;
        //dp[i][j] i个苹果放入j个盘子的分法，
        //dp[i][j] = dp[i][j-1] + dp[i-j][j]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j <= 1) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i][j - 1];
                if (i >= j) dp[i][j] += dp[i - j][j];
            }
        return dp[m][n];
    }
}
