package June.day10;

/**
 * 题目描述：给定两个整数，被除数 dividend 和除数 divisor。
 * 将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * Date:19/6/15
 *示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = -1;
        System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
    }

    //未考虑清楚特殊情形，未通过
    public int divide(int dividend, int divisor) {
        //把两个数都转为负数
        int sign = 1;
        if (dividend > 0) {
            dividend =  -dividend;
            sign = -sign;
        }
        if (divisor > 0) {
           divisor = -divisor;
           sign = -sign;
        }
        //排除除数数字0
        if (dividend == 0) {
            return 0;
        }
        int res = 0;
        int dividendTmp = dividend;
        int divisorTmp = divisor;
        while (dividendTmp <= divisorTmp) {
            int tmp = divisorTmp;
            int i = 1;
            while (dividendTmp <= tmp) {
                dividendTmp -= tmp;
                //防止溢出
                if(res  > Integer.MAX_VALUE - i ){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                res += i;
                //防止溢出
                if(Integer.MIN_VALUE - tmp < tmp){
                    tmp <<=1;
                    i<<=1;
                }
            }
        }
        return sign==1?res:-res;
    }

    //大佬思路：有点问题，是用来long类型
//    作者：powcai
//    链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-xiang-chu-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int divide1(int dividend, int divisor) {
        int sign = (dividend ^ divisor) >> 31;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        long res = 0;
        while (lDividend >= lDivisor) {
            long tmp = lDivisor;
            long i = 1;
            while (lDividend >= tmp) {
                lDividend -= tmp;
                res += i;
                i <<= 1;
                tmp <<= 1;
            }
        }
        if (sign == -1) res *= -1;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }

}
