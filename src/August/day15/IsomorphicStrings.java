package August.day15;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：205. Isomorphic Strings
 * @Data 19/8/30
 * @题目描述： Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * @题目地址： 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * @示例1: ######
 * Input: s = "egg", t = "add"
 * Output: true
 * @示例2: ###
 * Input: s = "foo", t = "bar"
 * Output: false
 * @示例3: ###
 * Input: s = "paper", t = "title"
 * Output: true
 */

public class IsomorphicStrings {

    //注意是交叉映射  例如  ab aa  ==> false
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
