package Year2020.November.day04;

import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String A = scanner.next();
            String B = scanner.next();
            System.out.println(calStringDistance(A,B));
        }
    }

    /**
     * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
     * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
     * 编辑距离的算法是首先由俄国科学家Levenshtein提出的，故又叫Levenshtein Distance。
     */

    public static int calStringDistance(String charA, String charB) {
        //DP[i][j] 表示由i转换为j需要的操作数
        // dp[i][j] = {dp[i][j-1] + 1,dp[i-1][j] + 1,dp[i-1][j-1] + char[i] == char[j]?0:1}
        int N = charA.length(), M = charB.length();
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) dp[i][0] = dp[i - 1][0] + 1;
        for (int j = 1; j <= M; j++) dp[0][j] = dp[0][j - 1] + 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                int temp = dp[i - 1][j - 1];
                if (charA.charAt(i - 1) != charB.charAt(j - 1)) {
                    temp++;
                }
                dp[i][j] = Math.min(dp[i][j], temp);
            }
        }
        return dp[N][M];

    }
}
