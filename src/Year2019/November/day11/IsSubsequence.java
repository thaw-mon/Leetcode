package Year2019.November.day11;

/**
 * @题目 ： 392. Is Subsequence
 * @Data 19/11/30
 * @题目描述： Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * @题目链接： 链接：https://leetcode-cn.com/problems/is-subsequence
 * @示例1: ######
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * @示例2: ######
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 * @示例3: ###
 */

public class IsSubsequence {

    //判断s是不是t的子序列
    //当s==t就会出错
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        boolean flag = true;
        for (char c : s.toCharArray()) {
            flag = false;
            if (j == t.length())
                break;
            while (j < t.length()) {
                if (t.charAt(j++) == c) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

}
