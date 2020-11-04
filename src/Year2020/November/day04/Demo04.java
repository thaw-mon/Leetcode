package Year2020.November.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Demo04 {

    //TODO 这道题就是前一天的demo05
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Year2020/November/day03/exp05_01");
        // Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String exp = scanner.next();
            System.out.println(calculate(exp));
        }
    }

    /**
     * 功能：四则运算
     * pucExpression字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。
     * pucExpression算术表达式的有效性由调用者保证;
     *
     * @param strExpression 字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"
     * @return 算术表达式的计算结果
     */
    public static int calculate(String strExpression) {
        //1.定义数字栈
        Stack<Integer> numStack = new Stack<>();
        //2.定义符号栈
        Stack<Character> symbolStack = new Stack<>();
        boolean isNegativeNum = false;
        int n = strExpression.length();
        int index = 0;
        while (index < n) {
            char c = strExpression.charAt(index);
            //判断符号类型
            if (c >= '0' && c <= '9') {
                int val = 0;
                while (index < n) {
                    c = strExpression.charAt(index);
                    if (c >= '0' && c <= '9') {
                        val *= 10;
                        val += (c - '0');
                        index++;
                    } else {
                        break;
                    }
                }
                if (isNegativeNum) {
                    val = -val;
                    isNegativeNum = false;
                }

                numStack.push(val);
                //判断符号栈和下一个符号的等级
                //level.getOrDefault(strExpression.charAt(index+1),-1)
                //A+B-C 或A*B+C
                //把下面部分写成函数
                if (index < n && isOperator(strExpression.charAt(index))) {
                    beginOp(symbolStack, numStack, strExpression.charAt(index));
                }

            } else if (c == '-') {
                //判断是符号，还是负号
                if (index == 0 || isOperator(strExpression.charAt(index - 1)) || isLeftSymbol(strExpression.charAt(index - 1))) {
                    isNegativeNum = true;
                } else {
                    symbolStack.push(c);
                }
                index++;
            } else if (c == '}' || c == ']' || c == ')') {
                //计算符号内的结果
                while (!symbolStack.isEmpty()) {
                    c = symbolStack.pop();
                    if (c == '{' || c == '[' || c == '(') {
                        if (index + 1 < n && isOperator(strExpression.charAt(index + 1))) {
                            beginOp(symbolStack, numStack, strExpression.charAt(index + 1));
                        }
                        // beginOp(index, n, symbolStack, numStack, strExpression);
                        break;
                    }
                    int n2 = numStack.pop();
                    int n1 = numStack.pop();
                    int ret = Operator(n1, n2, c);
                    numStack.push(ret);
                }
                index++;
            } else {
                symbolStack.push(c);
                index++;
            }
        }

        while (!symbolStack.isEmpty()) {
            int n2 = numStack.pop();
            int n1 = numStack.pop();
            char c3 = symbolStack.pop();
            int ret = Operator(n1, n2, c3);
            numStack.push(ret);
        }
        return numStack.pop();

    }

    private static boolean isLeftSymbol(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int Operator(int n1, int n2, char c) {
        switch (c) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            default:
                System.out.println("error opt");
                return 0;
        }
    }

    private static void beginOp(Stack<Character> symbolStack, Stack<Integer> numStack, char c) {
        Map<Character, Integer> level = new HashMap<>();
        level.put('+', 0);
        level.put('-', 0);
        level.put('*', 1);
        level.put('/', 1);

        while (!symbolStack.isEmpty() && isOperator(symbolStack.peek())) {
            char pre = symbolStack.peek();
            if (level.get(pre) >= level.get(c)) {
                int n2 = numStack.pop();
                int n1 = numStack.pop();
                char c3 = symbolStack.pop();
                int ret = Operator(n1, n2, c3);
                numStack.push(ret);
            } else {
                break;
            }
        }
    }
}
