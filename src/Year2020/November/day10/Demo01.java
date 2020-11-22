package Year2020.November.day10;

import java.util.Scanner;

public class Demo01 {
    /**
     * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
     * 所谓回文串，指左右对称的字符串。
     * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
     */
    public static int maxPalindromeStr(String str) {
        int N = str.length();
        if (N == 0) return 0;
        int[] dp = new int[N];
        dp[0] = 1;
        int count = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = str.charAt(i) == str.charAt(i - 1) ? 2 : 1; //初始值
            int left = i - 1 - dp[i - 1];
            if (left >= 0 && str.charAt(left) == str.charAt(i)) {
                dp[i] = dp[i - 1] + 2;
            }
            count = Math.max(count, dp[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(maxPalindromeStr(s));
        }
        scanner.close();
    }
}
