package Year2019.September.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @题目 ： 241. Different Ways to Add Parentheses
 * @Data 19/9/18
 * @题目描述： Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * @题目地址： 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 * @示例1: ######
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * @示例2: ###
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10  (漏掉了这种情况)
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * @示例3: ###
 */

public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        Stack<Integer> demo = new Stack<>();
        demo.push(2);
        demo.push(3);
        // pop的结果是从左到右的 ans = 3- 2 = 1
        System.out.println(new DifferentWaysToAddParentheses().operator(demo.pop(), demo.pop(), '-'));

        String input = "2*3-4*5";
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute(input));
    }

    List<Integer> res = new ArrayList<>();
    Stack<Integer> numberStack = new Stack<>();
    Stack<Character> symbolStack = new Stack<>();

    //思路: 递归+回溯
    public List<Integer> diffWaysToCompute(String input) {
        if(input.length()==0) return res;
        if(input.contains("+") || input.contains("-") || input.contains("*"))
            helper(input);
        else
            res.add(Integer.parseInt(input));
        return res;
    }

    private void helper(String input) {
        if (input.length() == 0) {
            //进行计算结果
            int num = 0;
            Stack<Integer> tmpNum = new Stack<>();
            tmpNum.addAll(numberStack);
            Stack<Character> tmpSymbol = new Stack<>();
            tmpSymbol.addAll(symbolStack);
            while (!tmpSymbol.isEmpty()) {
                char c = tmpSymbol.pop();
                int num2 = tmpNum.pop();
                int num1 = tmpNum.pop();
                num = operator(num1, num2, c);
                tmpNum.push(num);
            }
            res.add(tmpNum.pop());
            return;
        }
        //
        int n = input.length();
        int symbol_index = 0;
        int num_index = 0;
        int i = 0;
        //进行计算或直接进入下一轮
        if (!symbolStack.isEmpty()) {
            int right = numberStack.pop();
            int left = numberStack.pop();
            char symbol = symbolStack.pop();
            int tmp = operator(left, right, symbol);
            numberStack.push(tmp);
            helper(input.substring(i));
            //回溯
            numberStack.pop();
            numberStack.push(left);
            numberStack.push(right);
            symbolStack.push(symbol);
        }
        while (i < n) {
            char c = input.charAt(i);
            //字符为数字
            if (c >= '0' && c <= '9') {
                int number = 0;
                while (c >= '0' && c <= '9') {
                    number = number * 10 + c - '0';
                    if (++i >= n) break;
                    c = input.charAt(i);
                }
                numberStack.push(number);
                num_index++;
                //进行计算或直接进入下一轮
                if (!symbolStack.isEmpty()) {
                    int right = numberStack.pop();
                    int left = numberStack.pop();
                    char symbol = symbolStack.pop();
                    int tmp = operator(left, right, symbol);
                    numberStack.push(tmp);
                    helper(input.substring(i));
                    //回溯
                    numberStack.pop();
                    numberStack.push(left);
                    numberStack.push(right);
                    symbolStack.push(symbol);
                }
            } else {
                symbolStack.push(c);
                symbol_index++;
                i++;
            }
        }
        //回溯
        while (num_index-- > 0) {
            numberStack.pop();
        }
        while (symbol_index-- > 0) {
            symbolStack.pop();
        }
    }


    private int operator(int num1, int num2, char c) {
        int res;
        switch (c) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            default:
                res = 0;
//                throw new Exception("Function : operator has illegal input :" + c);
        }
        return res;
    }


    //分治策略：
//     作者：thunder-zh
//    链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/java-fen-zhi-fa-zi-fu-chuan-chu-li-liang-chong-fan/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<Integer> diffWaysToCompute2(String input) {
        return partition(input);
    }

    public List<Integer> partition(String input) {
        List<Integer> result = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.valueOf(input));
            return result;
        }
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for(Integer left : partition(input.substring(0, i))) {
                    for (Integer right : partition(input.substring(i + 1))) {
                        if (input.charAt(i) == '+') {
                            result.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            result.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        return result;
    }


}
