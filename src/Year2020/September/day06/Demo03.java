package Year2020.September.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo03 {


    /**
     * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
     *
     * @param expression
     * @return
     */
    public boolean parseBoolExpr(String expression) {
        //创建符号栈和bool栈
        Stack<Character> symbolStack = new Stack<>();
        Stack<Character> numStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            //判定当前字符类型
            char c = expression.charAt(i);
            if (c == '&' || c == '|' || c == '!') {
                symbolStack.push(c);
            } else if (c == 't' || c == 'f' || c == '(') {
                numStack.push(c);
            } else if (c == ')') {
                //出栈并进行计算
                char symbol = symbolStack.pop(); //获取符号
                List<Character> num = new ArrayList<>(); //获取数字
                char tmp;
                while ((tmp = numStack.pop()) != '(') {
                    num.add(tmp);
                }
                numStack.push(compute(symbol, num));
            }
        }

        return numStack.pop() == 't';
    }

    //根据符号进行计算
    private char compute(char symbol, List<Character> num) {
        if (symbol == '&') {
            for (char c : num) {
                if (c == 'f') return 'f';
            }
            return 't';
        } else if (symbol == '|') {
            for (char c : num) {
                if (c == 't') return 't';
            }
            return 'f';
        } else {
            // '!'
            if (num.get(0) == 't') return 'f';
            else return 't';
        }
    }
}
