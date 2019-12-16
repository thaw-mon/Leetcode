package September.day12;

/**
 * @题目 ： 263. Ugly Number
 * @Data 19/9/19
 * @题目描述： Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * @题目地址： 链接：https://leetcode-cn.com/problems/ugly-number
 * @示例1: ######
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * @示例2: ###
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * @示例3: ###
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 */

public class UglyNumber {

    //判断数字是否为2，3，5的合数或其本身
    //注意数字0的判断
    public boolean isUgly(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
