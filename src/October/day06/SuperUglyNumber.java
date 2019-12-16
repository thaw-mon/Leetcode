package October.day06;

/**
 * @题目 ： 313. Super Ugly Number
 * @Data 19/10/13
 * @题目描述： Write a program to find the n^th super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * @题目地址： 链接：https://leetcode-cn.com/problems/super-ugly-number
 * @示例1: ######
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 * @示例2: ######
 * @示例3: ###
 */

public class SuperUglyNumber {
    public static void main(String[] args){
        int [] nums = {2,7,13,19};
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(12,nums));
    }
    //类似于之前的丑数  264. Ugly Number II
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int len = primes.length;
        int[] l = new int[len];
        for (int i = 1; i < n; i++) {
            dp[i] = getMin(dp, primes, l);
            update(l,dp[i],primes,dp);
        }
        return dp[n-1];
    }

    private int getMin(int[] dp, int[] primes, int[] l) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l.length; i++) {
            if (primes[i] * dp[l[i]] < min) {
                min = primes[i] * dp[l[i]];
            }
        }
        return min;
    }

    private void update(int[] l, int value, int[] primes,int[] dp) {
        for (int i = 0; i < primes.length; i++) {
            if (value >= primes[i] * dp[l[i]]) {
                l[i]++;
            }
        }
    }
}
