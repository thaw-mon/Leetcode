package November.day06;

/**
 * @题目 ： 371. Sum of Two Integers
 * @Data 19/11/15
 * @题目描述： Calculate the sum of two integers a and b, but you are not allowed to use the operator + and
 * @题目链接： 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * @示例1: ######
 * Input: a = 1, b = 2
 * Output: 3
 * @示例2: ######
 * Input: a = -2, b = 3
 * Output: 1
 * @示例3: ###
 */

public class SumTwoIntegers {

    public static void main(String[] args) {
        int a = 123, b = 456;
        System.out.println(new SumTwoIntegers().getSum(a, b));
    }

    //不用加号的加法：显然是使用位运算做加法
    public int getSum(int a, int b) {
        //三位数 加数+被加数+进位：异或运算
        // 加数+被加数 与运算符 --》获取进位标识符
        int res = a, carry = 0;
        while (b != 0) {
            res = a ^ b;
            carry = (a & b) << 1;
            a = res;
            b = carry;
        }
        return res;
    }
}
