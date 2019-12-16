package August.day14;

import java.util.Collections;

/**
 * @题目 ：190. Reverse Bits
 * @Data 19/8/29
 * @题目描述： Reverse bits of a given 32 bits unsigned integer.
 * @题目地址： 链接：https://leetcode-cn.com/problems/reverse-bits
 * @示例1: ######
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * @示例2: ###
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.
 * @示例3: ###
 */

public class ReverseBits {

    public static void main(String[] args) {
        int num = -3;
//        System.out.println(Integer.parseInt("11111111111111110110111101111101", 2));
        System.out.println(Integer.toBinaryString(-10));
//        System.out.println(new ReverseBits().reverseBits2(num));
    }

    //负数时存在问题
    public int reverseBits(int n) {
        //1. 把int转换为二进制字符串
        String s = Integer.toBinaryString(n);
        int len = 32 - s.length();

        StringBuilder sb = new StringBuilder();
        //
        sb.append(Collections.nCopies(len,'0'));
        sb.append(s);

        //2. 把二进制字符串翻转
        sb.reverse();

        //3. 把二进制字符串转换为int
        return Integer.parseInt(sb.toString(), 2);
    }

    // you need treat n as an unsigned value
    //大佬解法
    public int reverseBits2(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a = a + ((1 & (n >> i)) << (31 - i));
        }
        return a;
    }

}
