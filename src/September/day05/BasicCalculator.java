package September.day05;

import java.util.Stack;

/**
 * @题目 ： 224. Basic Calculator
 * @Data 19/9/07
 * @题目描述： Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * @题目地址： 链接：https://leetcode-cn.com/problems/basic-calculator
 * @示例1: ######
 * Input: "1 + 1"
 * Output: 2
 * @示例2: ###
 * Input: " 2-1 + 2 "
 * Output: 3
 * @示例3: ###
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new BasicCalculator().calculate(s));
    }

    //一个只有加减法和括号的简单计算器
    public int calculate(String s) {
        Stack<Character> symbol = new Stack<>();
        Stack<Integer> num = new Stack<>();
        boolean isNumber = false;
        int len = s.length();
        int i = 0;
        while (i < len) {
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= len) break;
            //数字位
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = i;
                int tmp = 0;
                while (j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    tmp = tmp * 10 + s.charAt(j) - '0';
                    j++;
                }
                num.push(tmp);
                i = j;
            } else {
                //符号位
                if (s.charAt(i) == '(')
                    symbol.push(s.charAt(i));
                else if (s.charAt(i) == ')') {
                    //进行运算操作
                    if (num.size() > 1 && (symbol.peek() == '+' || symbol.peek() == '-')) {
                        //注意这里连续使用了两个pop stack = [1,2,3] num1 = 3 num2 = 2
                        int ans = helper(num.pop(), num.pop(), symbol.pop());
                        num.push(ans);
                    }
                    symbol.pop();
                } else {
                    //运算符进栈
                    //进行运算操作
                    if (num.size() > 1 && (symbol.peek() == '+' || symbol.peek() == '-')) {
                        int ans = helper(num.pop(), num.pop(), symbol.pop());
                        num.push(ans);
                    }
                    symbol.push(s.charAt(i));
                }
                i++;
            }


        }
        if (symbol.isEmpty())
            return num.pop();
        else {
            return helper(num.pop(), num.pop(), symbol.pop());
        }
    }

    private int helper(int num1, int num2, Character symbol) {
        switch (symbol) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            default:
                return 0;
        }
    }
}
