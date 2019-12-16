package June.day06;

import java.util.*;

/**
 * @Data 19/6/5
 * @题目描述： 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @示例 1:
 * 输入: "()"
 * 输出: true
 * @示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * @示例 3:
 * 输入: "(]"
 * 输出: false
 * @示例 4:
 * 输入: "([)]"
 * 输出: false
 * @示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "[]{}[[[";
        System.out.println(new ValidParentheses().isValid(s));
    }

    //很简单，使用栈就ok了
    //注意：最开始漏了 全是left符号情形 {{{{[[[((，需要最后的栈判断
    public boolean isValid(String s) {
        boolean res = true;
        //左括号集合
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
//        List<Character> leftParentheses = new ArrayList<Character>(Arrays.asList('(','[','{'));
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            //左符号
            if(map.containsValue(c)){
                stack.push(c);
                continue;
            }
            //右符号 通过右符号找到对应的左符号
            Character leftParenthese = map.get(c);
            //当栈为空或符号不匹配时，返回false
            if(stack.isEmpty() || !stack.pop().equals(leftParenthese)){
                res = false;
                break;
            }
        }
        //防止最后全是左符号{([
        if(!stack.isEmpty()){
            res = false;
        }
        return res;
    }
}
