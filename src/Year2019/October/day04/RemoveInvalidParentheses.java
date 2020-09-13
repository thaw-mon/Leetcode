package Year2019.October.day04;

import java.util.*;

/**
 * @题目 ： 301. Remove Invalid Parentheses
 * @Data 19/10/08
 * @题目描述： Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * @题目地址： 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * @示例1: ######
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * @示例2: ######
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * @示例3: ###
 * Input: ")("
 * Output: [""]
 */

public class RemoveInvalidParentheses {

    private String str;
    private Set<String> ans = new HashSet<>();

    public static void main(String[] args) {
        String s = ")(";
        List<String> res = new RemoveInvalidParentheses().removeInvalidParentheses(s);
        for (String s1 : res) {
            System.out.println(s1);
        }
    }
    //正确符号 in end :left == right
    //如果存在某处左括号小于右括号，那么存在无效符号
    public List<String> removeInvalidParentheses(String s) {

        str = s;
        //记录左右括号应该remove数量
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                if (leftCount > 0)
                    leftCount--;
                else
                    rightCount++;
            }
        }

        helper(0, new StringBuilder(), leftCount, rightCount);
        return new ArrayList<>(ans);
    }

    private void helper(int index, StringBuilder sb, int leftCount, int rightCount) {
        int preLength =sb.length();
        if (leftCount == 0 && rightCount == 0) {
            if (index < str.length()) {
                sb.append(str.substring(index));
            }
            //判断最后有效性
            if (isValid(sb)) {
                ans.add(sb.toString());
            }
            if (index < str.length()) {
                sb.delete(preLength,sb.length());
            }
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                if (leftCount > 0) {
                    helper(i + 1, sb, leftCount - 1, rightCount);
                }
            } else if (str.charAt(i) == ')') {
                if (rightCount > 0) {
                    helper(i + 1, sb, leftCount, rightCount - 1);
                }
            }
            sb.append(str.charAt(i));
        }
        sb.delete(preLength,sb.length());

    }

    private boolean isValid(StringBuilder sb) {
        int n = sb.length();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '(')
                left++;
            else if (sb.charAt(i) == ')') {
                right++;
                if (right > left) {
                    return false;
                }
            }
        }

        return left == right;
    }
}
