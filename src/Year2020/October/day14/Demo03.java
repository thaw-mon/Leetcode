package Year2020.October.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args) throws FileNotFoundException {
       // Scanner scanner = new Scanner(System.in);
        File file = new File("src/Year2020/October/day14/exp03_01");
        Scanner scanner = new Scanner(file);
        Demo03 demo03 = new Demo03();
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(demo03.getMaxPalindrome2(s));
        }
    }

    /**
     * 获取最大回文子串的长度
     * //1.使用DP O(N^2)
     */
    //Error : 这里的回文串要求是连续的，不连续的不能算是回文串
    public int getMaxPalindrome(String str) {
        //dp[i][j] [i-j]最大回文串长度
        int N = str.length();
        char[] arr = str.toCharArray();
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                if (i == 0) {
                    dp[j][j] = 1;
                } else if (i == 1) {
                    dp[j][j + i] = arr[j] == arr[i + j] ? 2 : 1;
                } else {
                    dp[j][i + j] = Math.max(dp[j][i + j - 1], dp[j + 1][i + j]);
                    if (arr[j] == arr[i + j]) {
                        dp[j][j + i] = Math.max(dp[j][j + i], dp[j + 1][j + i - 1] + 2);
                    }
                }
            }
        }
        return dp[0][N - 1];
    }

    public int getMaxPalindrome2(String str) {
        //dp[i]以i结尾的最大回文串长度
        int N = str.length();
        char[] arr = str.toCharArray();
        int[] dp = new int[N];
        dp[0] = 1;
        int maxCnt = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1; //最小为1
            if (arr[i - 1] == arr[i]) dp[i] = 2;
            int prev = i - dp[i - 1] - 1;
            if (prev >= 0 && arr[prev] == arr[i]) {
                dp[i] = Math.max(dp[i - 1] + 2, dp[i]);
            }
            maxCnt = Math.max(maxCnt, dp[i]);
        }
        return maxCnt;
    }

}
