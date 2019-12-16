package October.day07;

import java.util.*;

/**
 * @题目 ： 316. Remove Duplicate Letters
 * @Data 19/10/14
 * @题目描述： Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * 题目地址： 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * @示例1: ######
 * Input: "bcabc"
 * Output: "abc"
 * @示例2: ######
 * Input: "cbacdcbc"
 * Output: "acdb"
 * @示例3: ###
 */

public class RemoveDuplicateLetters {
    public static void main(String[] args){
        String s= "cbacdcbc";
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters(s));
    }
    //copy 大佬的解答
    public String removeDuplicateLetters(String s) {
        int[] charsCount = new int[26];//计算26字母数量
        boolean[] visited = new boolean[26];//标记字母是否已经入栈
        int len = s.length();
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            charsCount[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;//最终字符的长度
        for (int count : charsCount) {
            if (count > 0) index++;
        }
        char[] res = new char[index];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //有小字符的且满足其前面的字符在小字符后还有同样字符的，则出栈
            while (!stack.isEmpty() && c < stack.peek() && charsCount[stack.peek() - 'a'] > 1 && !visited[c - 'a']) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
                charsCount[pop - 'a']--;
            }
            if (visited[c - 'a']) {
                charsCount[c - 'a']--;//重复的字符根据游标往后移动，数量减一
                continue;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        while (!stack.isEmpty()) {
            res[--index] = stack.pop();
        }
        return String.valueOf(res);
    }
}
