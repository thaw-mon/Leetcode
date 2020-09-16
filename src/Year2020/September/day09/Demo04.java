package Year2020.September.day09;

import java.util.List;
import java.util.Stack;

public class Demo04 {

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
     * 1. 可以直接调用函数
     * 2. 自定义递归方法
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double myPower(double base, int exponent) {
        if (exponent == 0) return 1.0;
        if (exponent < 0) return 1.0 / Power2(base, -exponent);
        return Power2(base, exponent);
    }

    public double Power2(double base, int exponent) {
        //
        Stack<Double> stack = new Stack<>();
        int current = 1;
        double currentBase = base;
        double ret = 1.0;
        while (exponent > 0) {
            while (exponent < current) {
                current /= 2;
                currentBase = stack.pop();
            }
            exponent -= current;
            ret *= currentBase;

            stack.push(currentBase);
            current <<= 1; //*2操作
            currentBase *= currentBase; //

        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Demo04().myPower(0, 3));
        System.out.println(new Demo04().Power(0, 3));
    }
}
