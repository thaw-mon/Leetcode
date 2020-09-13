package Year2019.November.day09;

import java.util.Stack;

/**
 * @题目 ： 385. Mini Parser
 * @Data 19/11/25
 * @题目描述： Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Note: You may assume that the string is well-formed:
 * <p>
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * @题目链接： 链接：https://leetcode-cn.com/problems/mini-parser
 * @示例1: ######
 * Given s = "324",
 * <p>
 * You should return a NestedInteger object which contains a single integer 324.
 * @示例2: ######
 * Given s = "[123,[456,[789]]]",
 * <p>
 * Return a NestedInteger object containing a nested list with 2 elements:
 * <p>
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * i.  An integer containing value 456.
 * ii. A nested list with one element:
 * a. An integer containing value 789.
 * @示例3: ###
 */


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation


public class MiniParser {

    public static void main(String[] args) {
        String s = "233";
        System.out.println(new MiniParser().deserialize(s));
    }

    //注意： 每一个整数都是一个单独的NestedInteger
    //折腾了半天，结果发现oj的本地测试有问题
    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        if (s.charAt(0) != '[') {
            res.setInteger(Integer.parseInt(s));
            return res;
        }
        Stack<NestedInteger> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (stack.isEmpty()) {
                    stack.push(res);
                    continue;
                }
                NestedInteger nestedInteger = new NestedInteger();
                NestedInteger top = stack.peek();
                top.add(nestedInteger);
                stack.push(nestedInteger);
            } else if (c == ']') {
                stack.pop();

            } else {
                //c = 0-9和符号位-
                boolean flag = false;
                if (c == '-') {
                    i++;
                    flag = true;
                }
                int value = 0;
                int j = i;
                for (; j < s.length(); j++) {
                    c = s.charAt(j);
                    if (c < '0' || c > '9') {
                        break;
                    }
                    value *= 10;
                    value += c - '0';
                }
                if (flag) {
                    value = -value;
                }

                NestedInteger top = stack.peek();
                top.add(new NestedInteger(value));
                i = j - 1;
            }
            //跳过逗号
            if (i+1 < s.length() && s.charAt(i+1) == ',')
                i++;
        }
        return res;
    }

}
