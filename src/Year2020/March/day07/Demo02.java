package Year2020.March.day07;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo02 {

    public static void main(String[] args){
        String s= "3+5 / 2";
        System.out.println(new Demo02().calculate(s));
    }
    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
     *
     * @param s 简单的字符串表达式
     * @return 运算结果
     */
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>(); //定义操作数栈
        Deque<Character> operator = new ArrayDeque<>(); //定义操作符号栈
        int n = s.length();
        int index = 0;
        while (index < n) {
            char c = s.charAt(index);
            //获取符号栈
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator.add(c);
                index++;
            } else if (c == ' ') {
                index++;
            } else {
                int v = 0;
                while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    v *= 10;
                    v += s.charAt(index) - '0';
                    index++;
                }
                nums.add(v);
                if (nums.size() >= 2) {
                    char tmp = operator.getLast();
                    if (tmp == '*' || tmp == '/') {
                        operator.pollLast();
                        int b = nums.pollLast();
                        int a = nums.pollLast();
                        int ans = op(a, b, tmp);
                        nums.add(ans);
                    }
                }
            }
        }
        //进行剩余的加减法 : 要使用队列保持从左到右的运算顺序
        while (!operator.isEmpty()) {
            char tmp = operator.pop();
            int a = nums.pollFirst();
            int b = nums.pollFirst();
            int ans = op(a, b, tmp);
            nums.addFirst(ans);
        }

        return nums.pop();
    }

    public int op(int a, int b, char c) {
        int ret = 0;
        switch (c) {
            case '+':
                ret = a + b;
                break;
            case '-':
                ret = a - b;
                break;
            case '*':
                ret = a * b;
                break;
            case '/':
                ret = a / b;
                break;
            default:
                break;
        }
        return ret;
    }
}
