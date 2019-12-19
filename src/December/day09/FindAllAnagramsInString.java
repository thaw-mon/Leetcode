package December.day09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @题目 ：438. Find All Anagrams in a String
 * @Data 19/12/19
 * @题目描述： Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * @题目链接： 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * @示例1: ######
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * @示例2: ######
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * @示例3: ###
 */

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new FindAllAnagramsInString().findAnagrams(s, p));
    }

    //找到s中的子串，其全部字母和p一致（可以顺序不一致）
    //本质上是滑动窗口法
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        //1.记录子串p的hash表
        int[] maps = new int[26];
        for (char c : p.toCharArray()) {
            maps[c - 'a']++;
        }
        //2.遍历字符串s，判断是否存在子串
        int n = s.length();
        int[] temp = new int[26];
        int start = 0; //记录起始位置
        for (int i = 0; i < n; i++) {
            //字符属于字符串p
            if (maps[s.charAt(i) - 'a'] > 0) {
                temp[s.charAt(i) - 'a']++;
                while (start < i && temp[s.charAt(i) - 'a'] > maps[s.charAt(i) - 'a']) {
                    temp[s.charAt(start) - 'a']--;
                    start++;
                }
                if (i - start + 1 == p.length()) { //判断是否符合条件
                    res.add(start);
                }
            } else {
                //当前字符不属于p,清空temp
                // 可以增加set记录p存在字符的位置，用以减少初始化的次数
                for (int k = 0; k < 26; k++)
                    temp[k] = 0;
                start = i + 1;
            }
        }

        return res;
    }
}
