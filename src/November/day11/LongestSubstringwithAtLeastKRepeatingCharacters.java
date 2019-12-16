package November.day11;

/**
 * @题目 ： 395. Longest Substring with At Least K Repeating Characters
 * @Data 19/11/30
 * @题目描述： Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * @题目链接： 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * @示例1: ######
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * @示例2: ######
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * @示例3: ###
 */

public class LongestSubstringwithAtLeastKRepeatingCharacters {


    //找到最长字串：子串中的每个字母最少出现了k次
    //需要优化减枝，否则递归很慢 减枝后时间有100ms减少到1ms
    public int longestSubstring(String s, int k) {
        if (k < 2) return s.length();
        if (s.isEmpty() || s.length() < k) return 0;
        int[] letters = new int[26];
        for (Character c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        int i = 0;
        //1 找到第一个符合条件的字母
        while (i < s.length() && letters[s.charAt(i) - 'a'] < k) i++;
        int l_start = i;

        //2.找到第一个不符合条件的字母作为分割l,r的节点
        while (i < s.length() && letters[s.charAt(i) - 'a'] >= k) i++;
        if (i == s.length()) return s.length() - l_start;

        //左边最大字串长度
        int l = longestSubstring(s.substring(l_start, i), k);
        //右边最大子串长度
        while (i < s.length() && letters[s.charAt(i) - 'a'] < k) i++;
        int r_start = i;
        //右边不可能超过左边,不用在计算右边了
        if (s.length() - r_start <= l)
            return l;

        int r = longestSubstring(s.substring(r_start), k);

        return Math.max(l, r);
    }


}
