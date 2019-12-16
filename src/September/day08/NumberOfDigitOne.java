package September.day08;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ： 233. Number of Digit One
 * @Data 19/9/15
 * @题目描述： Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * @题目地址： 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * @示例1: ######
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * @示例2: ###
 * @示例3: ###
 */

public class NumberOfDigitOne {
    public static void main(String[] args) {
        // 1234 --> 689
        // 123 --> 57
        // 23 --13  ok
        System.out.println(new NumberOfDigitOne().countDigitOne(1230));
    }

    //计算数字1出现的次数
    //注意： 类似于 11 111 中的一需要进行重复计算的
    //发现规律 前i位1的sum + i * pow(10,i-1)  1 20 300 4000 .....
    public int countDigitOne(int n) {
        int res = 0;
        int[] Digits = new int[32];
        int val = 0, len = 0;
        while (n > 0) {
            val = n % 10;
            n = n / 10;
            Digits[len++] = val;
        }


        for (int i = len - 1; i >= 0; i--) {
            if (Digits[i] == 0)
                continue;
            //增加比当前数字小一位的 1 的个数
            res += i * Math.pow(10, i - 1);

            if (Digits[i] == 1) {
                int tmp = 0;
                for (int j = i - 1; j >= 0; j--) {
                    tmp *= 10;
                    tmp += Digits[j];
                }
                tmp++;
                res += tmp;
            } else {
                int tmp = 0;
                tmp += Math.pow(10, i) + (Digits[i] - 1) * Math.pow(10, i - 1) * i;
                res += tmp;
            }
        }

        return res;
    }

    //    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/number-of-digit-one/solution/shu-zi-1-de-ge-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //这里找到了更加简洁的公式
    int countDigitOne2(int n) {
        int countr = 0;
        for (long i = 1;
             i <= n;
             i *= 10) {
            long divider = i * 10;
            countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return countr;
    }


}
