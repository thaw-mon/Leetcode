package January.day03;

/**
 * @题目 ：467. Unique Substrings in Wraparound String
 * @Data 20/01/08
 * @题目描述： Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * @题目链接： 链接：https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string
 * @示例1: ######
 * Input: "a"
 * Output: 1
 * <p>
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * @示例2: ######
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * @示例3: ###
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */

public class UniqueSubstringsInWraparoundString {
    //判断p中在S的子串
    //1.单个的字符
    //2.顺序且连续的字符
    public int findSubstringInWraproundString(String p) {
        int[] num = new int[26]; //记录从 a+i开始存在多少子串
        int i = 0, preLen = 0;
        while (i < p.length()) {
            char c = p.charAt(i); //记录起始位置字符
            int j = i; //获取终止位置
            if (preLen == 0) {
                //注意 z-a这个轮次
                while (j + 1 < p.length() && (p.charAt(j) + 1 == p.charAt(j + 1) || p.charAt(j) + 1 - 26 == p.charAt(j + 1))) {
                    j++;
                }
            } else {
                //上一轮已经判断了
                j = i + preLen - 1;
            }
            //abce a_len = 2; b_len = 1;
            num[c - 'a'] = Math.max(num[c - 'a'], j - i + 1);
            preLen = j - i;
            i++;
        }
        int res = 0;
        for (i = 0; i < 26; i++)
            res += num[i];
        return res;
    }
}
