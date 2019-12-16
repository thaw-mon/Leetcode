package September.day06;

import java.util.*;

/**
 * @题目 ： 227. Basic Calculator II
 * @Data 19/9/07
 * @题目描述： Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * @题目地址： 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * @示例1: ######
 * Input: "3+2*2"
 * Output: 7
 * @示例2: ###
 * Input: " 3/2 "
 * Output: 1
 * @示例3: ###
 * Input: " 3+5 / 2 "
 * Output: 5
 */

public class BasicCalculatorII {

    public static void main(String[] args) {
        String s = " 1+1+1 ";
        System.out.println(new BasicCalculatorII().calculate(s));
    }

    //常规解法：速率太慢
    //在1的基础上,去掉了括号,增加了 * / 运算符
    public int calculate(String s) {
        //1.中序转后序
        List<String> postFix = reverseToPostfixExp(s);
        //2. 逆波兰式计算结果
        return getResultByPostExp(postFix);
    }

    //中序转后序表达式算法 --> if else 嵌套太多，很难看啊！
    private List<String> reverseToPostfixExp(String s) {
        List<String> res = new ArrayList<>();
        Stack<Character> operator = new Stack<>();
        int len = s.length();
        int i = 0;
        while (i < len) {
            //空字符
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= len) break;
            //数字位
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = i;
                while (j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                //数字直接入栈
                res.add(s.substring(i, j));
                i = j;
            } else {
                //符号位 '(' 直接入栈
                if (s.charAt(i) == '(')
                    operator.add(s.charAt(i));
                    // ')'将符号栈出栈，直到遇到 '('
                else if (s.charAt(i) == ')') {
                    Character op;
                    //注意: 这里'('出operator栈了,但是没有如res栈
                    while ((op = operator.pop()) != '(') {
                        res.add(op.toString());
                    }

                } else {
                    //比较符号优先级
                    char c = s.charAt(i);
                    int currentPrior = getPrior(c);
                    int stackPrior = -1;
                    if (!operator.isEmpty()) {
                        stackPrior = getPrior(operator.peek());
                    }
                    //当栈顶操作符优先级大于等于当前操作符的优先级，出栈
                    while (currentPrior <= stackPrior) {
                        res.add(operator.pop().toString());
                        //operator为空情形
                        if (operator.isEmpty())
                            stackPrior = -1;
                        else
                            stackPrior = getPrior(operator.peek());
                    }
                    operator.push(c);
                }
                i++;
            }
        }
        while (!operator.isEmpty()) {
            res.add(operator.pop().toString());
        }
        return res;
    }

    //对后序表达式进行计算操作(逆波兰表达式计算法)
    private int getResultByPostExp(List<String> list) {
        int n = list.size();
        Stack<Integer> stack = new Stack<>();
        Set<String> symbol = new HashSet<>();
        symbol.add("+");
        symbol.add("-");
        symbol.add("*");
        symbol.add("/");
        for (String str : list) {
            if (symbol.contains(str)) {
                //在一个函数中使用pop作为参数 参数是从右到左的
                int tmp = Operating(stack.pop(), stack.pop(), str);
                stack.push(tmp);
            } else
                stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }

    //获取操作符的优先级
    private int getPrior(char operator) {
        int res = -1;
        //注意'('的优先级
        switch (operator) {
            case '(':
                res = 2;
                break;
            case '*':
            case '/':
                res = 1;
                break;
            case '+':
            case '-':
                res = 0;
                break;
            default:
        }
        return res;
    }

    //运算操作
    private int Operating(int num1, int num2, String symbol) {
        switch (symbol) {
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            default:
                return 0;
        }
    }
}
