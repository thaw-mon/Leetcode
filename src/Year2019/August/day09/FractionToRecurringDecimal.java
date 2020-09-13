package Year2019.August.day09;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：166. Fraction to Recurring Decimal
 * @Data: 19/8/15
 * @题目描述： Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * @题目地址： 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * @示例1: ######
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * @示例2: ###
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * @示例3: ###
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 **/

public class FractionToRecurringDecimal {
    public static void main(String[] args) {

//        System.out.println( Integer.MIN_VALUE / -1);
        //结果产生溢出了
//        int res = Integer.MIN_VALUE / -1;
//        System.out.println((double) -4 / 3);
//        System.out.println(-4 % 3);
//        System.out.println(res);

        int d1 = 350;
        int d2 = 74;
        System.out.println(d1 / d2);
        System.out.println(d1 % d2);

        int d3 = 35;
        int d4 = 7;
        System.out.println(d3 / d4);
        System.out.println(d3 % d4);
        int numerator = -1;
        int denominator = Integer.MIN_VALUE;
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(numerator, denominator));
    }

    //做除法,获取商-->如何判断结果是除不尽的小数呢，也就是如何找到循环点
    //关键点 : 小数部分循环点寻找  除0  最大最小值的计算
    //  Question : 下面两种情形如何处理 既然没说不能使用long 类型，那么可以直接使用long替代
    //num = Integer.MIN_VALUE denomin = -1
    //num = -1  denomin = Integer.MIN_VALUE

    //直接使用long解决法
    public String fractionToDecimal(int numerator, int denominator) {

        long numeratorCopy = numerator;
        long denominatorCopy = denominator;
        //除0运算
        if (denominatorCopy == 0) {
            throw new ArithmeticException();
        }

        //被除数为0的情形，防止后面的-0出现
        if (numeratorCopy == 0)
            return new String("0");

        //处理符号位置 全部转换为正数
        boolean flag = true;
        if (numeratorCopy < 0) {
            numeratorCopy = -numeratorCopy;
            flag = !flag;
        }
        if (denominatorCopy < 0) {
            denominatorCopy = -denominatorCopy;
            flag = !flag;
        }
        //循环数 使用map保存
        Map<Long, Integer> loopNum = new HashMap<>();

        //1. 定义保存结果的String
        StringBuilder str = new StringBuilder();
        //负数插入符号位
        if (!flag) str.append("-");

        //定义商
        long consult = 0;
        //计算整数部分
        consult = numeratorCopy / denominatorCopy;
        numeratorCopy = numeratorCopy % denominatorCopy;

        str.append(consult);
        if (numeratorCopy != 0)
            str.append(".");
        //不能直接使用乘法，除数过大时会导致溢出问题
        numeratorCopy *= 10;
        //进入小数部分
        int index = str.length();
        while (numeratorCopy != 0) {

            //保存循环数
            loopNum.put(numeratorCopy, index++);
            //获得商和余数
            consult = numeratorCopy / denominatorCopy;
            numeratorCopy = numeratorCopy % denominatorCopy;
            str.append(consult);

            numeratorCopy *= 10;
            //检查循环数
            if (loopNum.containsKey(numeratorCopy)) {
                index = loopNum.get(numeratorCopy);
                break;
            }
        }
        //找到循环数跳出
        if (numeratorCopy != 0) {
            str.insert(index, "(");
            str.append(")");
        }
        return str.toString();
    }

    //TODO 考虑不使用long类型的写法（未实现）
    public String fractionToDecimal2(int numerator, int denominator) {

        //除0运算
        if (denominator == 0) {
            throw new ArithmeticException();
        }

        //TODO 处理符号之前，要考虑最小值溢出问题

        //处理符号位置 全部转换为正数  ==>考虑全部转换为负数的可能性
        boolean flag = true;
        if (numerator < 0) {
            numerator = -numerator;
            flag = !flag;
        }
        if (denominator < 0) {
            denominator = -denominator;
            flag = !flag;
        }
        //循环数 使用map保存
        Map<String, Integer> loopNum = new HashMap<>();

        //1. 定义保存结果的String
        StringBuilder str = new StringBuilder();

        //负数插入符号位
        if (!flag) str.append("-");

        //定义商
        int consult = 0;
        //计算整数部分
        consult = numerator / denominator;
        numerator = numerator % denominator;

        str.append(consult);
        if (numerator != 0)
            str.append(".");
        //不能直接使用乘法，除数过大时会导致溢出问题
        //进入小数部分
        int index = str.length();
        while (numerator != 0) {

            //保存循环数
            loopNum.put(String.valueOf(numerator), index++);

            //数字溢出情形，无法直接乘10
            if (numerator > Integer.MAX_VALUE >> 1) {
                consult = numerator / (denominator >> 1);
                numerator = numerator * 10 - denominator * consult;
            }
            numerator *= 10;
            //获得商和余数
            consult = numerator / denominator;
            numerator = numerator % denominator;
            str.append(consult);


            //检查循环数
            if (loopNum.containsKey(String.valueOf(numerator))) {
                index = loopNum.get(String.valueOf(numerator));
                break;
            }
        }
        //找到循环数跳出
        if (numerator != 0) {
            str.insert(index, "(");
            str.append(")");
        }
        return str.toString();
    }

    //采用数学原理法 :根据循环节的特性来处理。-->代码链接如下
//      作者：mtleo
//    链接：https://leetcode-cn.com/problems/two-sum/solution/javahuo-qu-xun-huan-jie-cong-shi-yao-wei-zhi-kai-s/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
