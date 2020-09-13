package Year2019.November.day04;

/**
 * @题目 ： 357. Count Numbers with Unique Digits
 * @Data 19/11/12
 * @题目描述： Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * @题目链接： 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * @示例1: ######
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 * @示例2: ######
 * @示例3: ###
 */

public class CountNumberswithUniqueDigits {

    //数字是以n的指数级的增长，因此必然存在规律或数学公式
    // n = 0  ans = 1
    // n = 1  ans = 10  1+ 1 * 9
    // n = 2  ans = 91  10 + 9 * 9
    // n = 3  ans = 91 + 81 * 8
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + (dp[i - 1]) * (10 - i);
                continue;
            }
            if (i >= 11) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - i + 1);
        }
        return dp[n];
    }
}
