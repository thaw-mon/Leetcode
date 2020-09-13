package Year2019.December.day01;

/**
 * @题目 ： 400. Nth Digit
 * @Data 19/12/02
 * @题目描述： Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * <p>
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * @题目链接： 链接：https://leetcode-cn.com/problems/nth-digit
 * @示例1: ######
 * Input:
 * 3
 * <p>
 * Output:
 * 3
 * @示例2: ######
 * Input:
 * 11
 * <p>
 * Output:
 * 0
 * <p>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * @示例3: ###
 */

public class NthDigit {

    public static void main(String[] args) {
        int n = 1000000000;
        System.out.println(new NthDigit().findNthDigit(n));
    }

    //求第n个数字
    //1-9       1位  9 * 1
    //10-99     2位  90 * 2
    //100-999   3位  900 * 3
    //1000-9999 4位  9000 * 4
    public int findNthDigit(int n) {
        //if (n < 10) return n;
        int bit = 1;
        long num = 9;
        long current = 0;
        //1.找到n对应数字的位数
        while (current + bit * num < n) {
            current += bit * num;
            bit++;
            num *= 10;
        }
        //2.找对对应的数字
        long ans = (n - current - 1) / bit + num / 9;
        //3.找到数字对应的位数
        long lbit = (n - current) % bit;
        if (lbit == 0) lbit += bit;
        //4.把对应位数的数字移到最后一位
        for (int i = 0; i < bit - lbit; i++)
            ans /= 10;

        ans %= 10;
        return (int)ans;
    }
}
