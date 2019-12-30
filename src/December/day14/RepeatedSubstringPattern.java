package December.day14;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @题目 ：459. Repeated Substring Pattern
 * @Data 19/12/30
 * @题目描述： Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * @题目链接： 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * @示例1: ######
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * @示例2: ######
 * Input: "aba"
 * Output: False
 * @示例3: ###
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class RepeatedSubstringPattern {
    //判断是否由重复的子串构成:假设一个字符串s重复N次，那么s+s必然重复2N次
    //此时判断t = s+s去掉头和尾 那么t包含了 2n-2个重复自创 如果t包含s 则有 2n-2 >= n ==> n>=2
//     作者：wandore
//        链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/guan-yu-gou-zao-ssjin-xing-pan-duan-de-zheng-ming-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean repeatedSubstringPattern(String s) {
        String str=s+s;
        str=str.substring(1,str.length()-1);
        return str.contains(s);

    }

    //上面的解法很有技巧性：现在加一种常规思路

    public boolean repeatedSubstringPattern2(String s) {
        /** i代表周期  第一个周期是 [0，i）*/
        for (int i = 1; i <= s.length() / 2 ; i ++) {
            if (s.length() % i != 0)
                continue;
            /** j代表下标 从 0 + i开始 而不是从 1 + i 开始 */
            /** j应该从i开始 而不是i + 1 */
            for (int j = i; j < s.length(); j ++) {
                if (s.charAt(j % i) != s.charAt(j))
                    break;
                if (j == s.length() - 1)
                    return true;
            }
        }
        return false;
    }
}
