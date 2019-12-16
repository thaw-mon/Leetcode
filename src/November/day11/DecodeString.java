package November.day11;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @题目 ： 394. Decode String
 * @Data 19/11/30
 * @题目描述： Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * @题目链接： 链接：https://leetcode-cn.com/problems/decode-string
 * @示例1: ######
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @示例2: ######
 * @示例3: ###
 */

public class DecodeString {

    //很简单的顺序扫描
    //"3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
    public String decodeString(String s) {
        //构建数字栈和字符栈
        StringBuffer sb = new StringBuffer();
        Stack<Integer> number = new Stack<>();
        Stack<String> str = new Stack<>();
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //c为数字
            if (c >= '0' && c <= '9') {
                int j = i;
                int num = 0;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num *= 10;
                    num += s.charAt(j) - '0';
                    j++;
                }
                number.push(num);
                i = j - 1;
            } else if (c == '[') {
                //do nothing
                level++;
            } else if (c == ']') {
                String s1 = str.pop();
                int n1 = number.pop();
                level--;

                s1 = String.join("", Collections.nCopies(n1, s1));
                //不需要迭代
                if (number.isEmpty()) { //level = 0
                    sb.append(s1);
                } else {
                    if (level == str.size())
                        s1 = str.pop() + s1;
                    str.push(s1);
                }
            } else {
                //为字符串
                //1.判断数字栈中是否存在数字，不存在说明不需要重复（即不需要如符号栈）
                int j = i;
                while (j < s.length() && ((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'))) {
                    j++;
                }

                if (number.isEmpty()) //level = 0
                    sb.append(s.substring(i, j));
                else {
                    String s1 = s.substring(i, j);
                    if (level == str.size()) {
                        s1 = str.pop() + s1;
                    }
                    str.push(s1);
                }

                i = j - 1;
            }
        }
        return sb.toString();
    }

    //思路一样但更简洁
//       作者：jyd
//    链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public String decodeString2(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }


}
