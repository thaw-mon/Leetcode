package June.day10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 题目描述：给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * Date:19/6/21
 *@示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * @示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s= "(()(()";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }

    //匹配问题第一感觉就是要用堆栈，遇到左括号就入栈，遇到右括号就出栈 长度加2
    //当右括号大于左括号时，长度清零
    //问题1 ：当面临 ())(()时，会返回4而实际应该是2
    //问题2 ： 当面临(()(()时，会返回4而实际是2
    public int longestValidParentheses(String s) {
        int res = 0;
        int preLength = 0;
        int length = 0;
        Stack<Character> parentheses = new Stack<>();

        for(char c :s.toCharArray()){
            if(c=='('){
                parentheses.push(c);
            } else {
                if(parentheses.isEmpty()){
                    res = Math.max(res,preLength);
                    length = 0;
                    preLength = 0;
                    continue;
                }
                parentheses.pop();
                length+=2;
            }
            if(parentheses.isEmpty()){
                preLength = preLength + length;
                length = 0;
            }
        }
        if(parentheses.isEmpty()){
            res = Math.max(res,preLength);
        } else {
            res = Math.max(res,preLength);
            res = Math.max(res,length);
        }
        return res;
    }

    //大佬思路1：
//    作者：powcai
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zui-chang-you-xiao-gua-hao-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        //System.out.println(stack);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    //思路2：动态规划
//    作者：powcai
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zui-chang-you-xiao-gua-hao-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int longestValidParentheses3(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }



}
