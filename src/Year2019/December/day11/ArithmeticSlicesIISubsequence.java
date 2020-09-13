package Year2019.December.day11;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：446. Arithmetic Slices II - Subsequence
 * @Data 19/12/23
 * @题目描述： A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequences:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 *  
 * A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
 * <p>
 * A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.
 * <p>
 * The function should return the number of arithmetic subsequence slices in the array A.
 * <p>
 * The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.
 * @题目链接： 链接：https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence
 * @示例1: ######
 * Input: [2, 4, 6, 8, 10]
 * <p>
 * Output: 7
 * <p>
 * Explanation:
 * All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * @示例2: ######
 * @示例3: ###
 */

public class ArithmeticSlicesIISubsequence {

    public static void main(String[] args) {
        int[] A1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; //数字溢出情形
        int[] A = {0,2000000000,-294967296};
        System.out.println(new ArithmeticSlicesIISubsequence().numberOfArithmeticSlices(A));
    }

    //判断数组中存在多少个等差数列(不需要连续)
    //动态规划思路 ： dp[j] 表示包括a[j]存在多少个等差数列（如何记录等差数列的差值，因为是不连续的）
    //考虑使用map记录全部等差数列的差值（面对上面实例会导致内存溢出情形 ）
    //思路没问题，但需要优化 为二维 d[j][k] 表示 以a[j]结尾的等差的k的等差数列数量

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length; //记录数组的长度
        if (n < 3) return 0;
        Map<Integer, Integer>[] maps = new Map[n];  //数组maps[i]表示以i结尾的等差数列个数（包括长度为2的弱等差数列）
        int res = 0; //记录等差数列的总数
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>(i);
            for (int j = i - 1; j >= 0; j--) {
                long diff = (long) A[i] - (long)A[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;
                //判断diff在maps[j]的数量
                int num = maps[j].getOrDefault((int) diff, 0);
                res += num;
                maps[i].put((int) diff, maps[i].getOrDefault((int) diff, 0) + num + 1); //+1表示弱等差数列
            }
        }
        return res;
    }
}
