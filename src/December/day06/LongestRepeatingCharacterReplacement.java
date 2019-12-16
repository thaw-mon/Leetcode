package December.day06;

import java.util.List;

/**
 * @题目 ：424. Longest Repeating Character Replacement
 * @Data 19/12/12
 * @题目描述： Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * <p>
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * <p>
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 * <p>
 * Note:
 * Both the string's length and k will not exceed 104.
 * @题目链接： 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * @示例1: ######
 * Input:
 * s = "ABAB", k = 2
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * @示例2: ######
 * Input:
 * s = "AABABBA", k = 1
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * @示例3: ###
 */

public class LongestRepeatingCharacterReplacement {
    //最多替换k个字符使得重复字符最大
    //1.暴力法(勉强通过)
    public int characterReplacement(String s, int k) {
        int res = 0;
        int i = 0;
        //没有考虑向前替换的情形
        while (i < s.length()) {
            char c = s.charAt(i);
            int len = 0;
            while (i < s.length() && s.charAt(i) == c) {
                i++;
                len++;
            }
            //此时的i不等于c了
            int j = i, temp = k;
            while (j < s.length() && (temp > 0 || s.charAt(j) == c)) {
                if (s.charAt(j) != c) {
                    temp--;
                }
                j++;
                len++;
            }
            //考虑向前替换的情况
            if (temp > 0) {
                len += Math.min(temp, i);
            }
            if (len > res) res = len;
        }
        return res;
    }

    //优化策略：滑动窗口法
    // 作者：xiaoneng
    //    链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/hua-dong-chuang-kou-chang-gui-tao-lu-by-xiaoneng/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int characterReplacement2(String s, int k) {
        int[] count = new int[26];//建立字符->字符数量的映射

        int left = 0, right = 0, result = 0, maxCount = 0;

        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right)- 'A']);//当前窗口内的最多字符的个数
            while (right - left + 1 - maxCount > k) {//需要替换的字符个数就是当前窗口的大小减去窗口中数量最多的字符的数量
                count[s.charAt(left) - 'A']--;//缩小窗口
                left++;
            }
            //当窗口内可替换的字符数小于等于k时，我们需要根据该窗口长度来确定是否更新result
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }


}
