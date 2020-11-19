package Year2020.November.day08;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();

            System.out.println(getCommonStrLength(s1,s2));
        }
        scanner.close();
    }
    /**
     * 计算两个字符串的最大公共字串的长度，字符不区分大小写
     */
    public static int getCommonStrLength(String pFirstStr, String pSecondStr) {
        int N1 = pFirstStr.length(), N2 = pSecondStr.length();
        int[][] dp = new int[N1 + 1][N2 + 1];
        int maxLen = 0;
        for (int i = 1; i <= N1; i++) {
            for (int j = 1; j <= N2; j++) {
                if (isEqual(pFirstStr.charAt(i - 1), pSecondStr.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }

    public static boolean isEqual(char c1, char c2) {

        if (c1 >= 'A' && c1 <= 'Z') {
            c1 += 32;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            c2 += 32;
        }
        return c1 == c2;
    }

}
