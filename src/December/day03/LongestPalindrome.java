package December.day03;

/**
 * @题目 ：409. Longest Palindrome
 * @Data 19/12/05
 * @题目描述： Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * @题目链接： 链接：https://leetcode-cn.com/problems/longest-palindrome
 * @示例1: ######
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * @示例2: ######
 * @示例3: ###
 */

public class LongestPalindrome {
    //求可以有s构成的最大回文子串
    //bucket:注意大小写
    public int longestPalindrome(String s) {
        int[] word1 = new int[26];
        int[] word2 = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                word1[c - 'a']++;
            } else
                word2[c - 'A']++;
        }
        int evens = 0;  //奇数字母
        int odds = 0;   //
        for (int i = 0; i < 26; i++) {
            odds += word1[i] / 2 * 2;
            odds += word2[i] / 2 * 2;
            if (word1[i] % 2 > 0 || word2[i] % 2 > 0) {
                evens += 1;
            }
        }
        int res = evens > 0 ? 1 : 0;
        res += odds;
        return res;
    }
}
