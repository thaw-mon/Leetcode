package Year2020.July.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title : 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * @Date : 2020/07/13
 * @思路 ：
 */

public class Demo03 {

    //-
    //-1
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        //TODO 如何处理特例 -2147483648 / -1 （溢出了）
        //1.改为long类型 2.增加判断条件
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        boolean flag = true; //默认为正数
        //1.全部变为负整数类型
        if (dividend > 0) {
            flag = !flag;
            dividend = -dividend;
        }
        if (divisor > 0) {
            flag = !flag;
            divisor = -divisor;
        }
        //用加法替代乘法,用减法替代除法
        int ret = 0;
        //优化策略使用阶梯法 , 每次divisor可以倍增
        List<Integer> divisors = new ArrayList<>();
        List<Integer> countNum = new ArrayList<>();
        divisors.add(divisor);
        countNum.add(1);
        while (dividend < 0) {
            for (int i = divisors.size() - 1; i >= 0; i--) {
                int tmp = divisors.get(i);
                if (dividend - tmp <= 0) {
                    dividend -= tmp;
                    ret += countNum.get(i);
                    if (i == divisors.size() - 1) {
                        divisors.add(tmp + tmp);
                        countNum.add(countNum.get(i) + countNum.get(i));
                    }
                }
            }
            //剩余值小于1份dividend
            if (dividend > divisor)
                break;
        }
        return flag ? ret : -ret;
    }

    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        int a = -2147483648;
        int b = -1;
        System.out.println(demo03.divide(a, b));
    }
}
