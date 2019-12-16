package September.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ： 264. Ugly Number II
 * @Data 19/9/20
 * @题目描述： Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * @题目地址： 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * Note:
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 * @示例1: ######
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * @示例2: ###
 * @示例3: ###
 */

public class UglyNumberII {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(new UglyNumberII().nthUglyNumber(n));
    }

    //寻找第n个属于uglyNumber的数字:注意是只包含2、3、5的数字
    //首先采用 暴力法 + 剪枝 :结果超时了
    //思路2 : 采用小根堆思路，每次选择最小值 * 2,3,5 然后再插入堆中 （可以直接使用java priorityQueue）
    //思路3:采用动态规划思路 dp[i] 表示第i个丑数 dp[i] = min(2 * dp[l_2], 3 * dp[l_3], 5 * dp[l_5])
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int l_2 = 0;
        int l_3 = 0;
        int l_5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(2 * dp[l_2], Math.min(3 * dp[l_3], 5 * dp[l_5]));
            if (dp[i] >= 2 * dp[l_2])
                l_2++;
            if (dp[i] >= 3 * dp[l_3])
                l_3++;
            if (dp[i] >= 5 * dp[l_5])
                l_5++;

        }
        return dp[n - 1];
    }

}
