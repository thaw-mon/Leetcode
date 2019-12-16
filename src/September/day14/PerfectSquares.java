package September.day14;

/**
 * @题目 ： 279. Perfect Squares
 * @Data 19/9/25
 * @题目描述： Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * @题目地址： 链接：https://leetcode-cn.com/problems/perfect-squares
 * @示例1: ######
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * @示例2: ###
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * @示例3: ###
 */

public class PerfectSquares {
    //不能直接每次选择最接近的 例如 12 = 4+4+4(len = 3) = 9+1+1+1(len =4)
    //TODO 结果有问题
    public int numSquares(int n) {
        int count = 0;
        while (n > 0) {
            int tmp = (int) Math.sqrt(n);
            count++;
            n -= tmp * tmp;
        }
        return count;
    }

    //动态规划思路
    public int numSquares2(int n) {
        //定义动态数组
        //dp[i] = MIN(dp[i], dp[i - j * j] + 1)
        int[] dp = new int[n + 1];
        dp[0] = 0;
        //定义基数和对应平方数
        int currentPoint = 1;
        int currentSquare = 1;

        for (int i = 1; i <= n; i++) {
            //处理为某个数的平方
            if (i == currentSquare) {
                dp[i] = 1;
                currentPoint++;
                currentSquare = currentPoint * currentPoint;
                continue;
            }
            dp[i] = dp[i - 1] + 1;
            //
            for (int j = 1; j < currentPoint; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }

        }
        return dp[n];
    }

    //3 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和

// def numSquares(self, n):
//        """
//        :type n: int
//        :rtype: int
//        """
//        while n % 4 == 0:
//            n /= 4
//        if n % 8 == 7:
//            return 4
//        a = 0
//        while a**2 <= n:
//            b = int((n - a**2)**0.5)
//            if a**2 + b**2 == n:
//                return (not not a) + (not not b)
//            a += 1
//        return 3
}
