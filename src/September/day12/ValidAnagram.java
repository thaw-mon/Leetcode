package September.day12;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ： 242. Valid Anagram
 * @Data 19/9/19
 * @题目描述： Given two strings s and t , write a function to determine if t is an anagram of s.
 * @题目地址： 链接：https://leetcode-cn.com/problems/valid-anagram
 * @示例1: ######
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * @示例2: ###
 * Input: s = "rat", t = "car"
 * Output: false
 * @示例3: ###
 */

public class ValidAnagram {

    //判断s和t是否全部字母相同，但是顺序不必相同
    //TODO 优化策略:由于s全是字母 所以可以使用 int[] table = new int[26]; 代替hashMap
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) return false;
        //把s转换为map
        Map<Character, Integer> sMap = new HashMap<>();
        int value;
        for (int i = 0; i < sLen; i++) {
            value = sMap.getOrDefault(s.charAt(i), 0);
            sMap.put(s.charAt(i), value + 1);
        }
        for (int i = 0; i < tLen; i++) {
            value = sMap.getOrDefault(t.charAt(i), 0);
            if (value == 0) return false;
            sMap.put(t.charAt(i), value - 1);
        }
        return true;
    }
}
