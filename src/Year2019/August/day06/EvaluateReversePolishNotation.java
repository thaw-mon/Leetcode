package Year2019.August.day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @题目 ：150. 逆波兰表达式求值
 * @Data: 19/8/11
 * @题目描述： 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * @题目地址： https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @说明： ###
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * @示例1: ######
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * @示例2: ###
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * @示例3: ###
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 **/

public class EvaluateReversePolishNotation {

    //逆波兰式通常使用栈来计算
    //TODO 可以优化的点 ： 把Map用Set替换，同时 Operating的symbol改为String(减少一次转换)
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if (n == 0) return 0;
        Map<String, Integer> symbol = new HashMap<>();
        symbol.put("+", 1);
        symbol.put("-", 2);
        symbol.put("*", 3);
        symbol.put("/", 4);
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (symbol.containsKey(s)) {
                int b = stack.pop();
                int a = stack.pop();
                int res = Operating(a, b, symbol.get(s));
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private int Operating(int a, int b, int symbol) {
        int res;
        switch (symbol) {
            case 1:
                res = a + b;
                break;
            case 2:
                res = a - b;
                break;
            case 3:
                res = a * b;
                break;
            case 4:
                res = a / b;
                break;
            default:
                res = 0;
        }
        return res;
    }

}
