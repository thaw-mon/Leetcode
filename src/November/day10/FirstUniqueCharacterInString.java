package November.day10;

/**
 * @题目 ： 387. First Unique Character in a String
 * @Data 19/11/29
 * @题目描述： Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * @题目链接： 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * @示例1: ######
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * @示例2: ######
 * @示例3: ###
 */

public class FirstUniqueCharacterInString {
    //找第一个唯一的字符
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        int res = s.length() + 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters[c - 'a'] == 0)
                letters[c - 'a'] = i + 1;
            else
                letters[c - 'a'] = s.length() + 1;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0 && letters[i] - 1 < res)
                res = letters[i] - 1;
        }
        if(res == s.length())
            res = -1;
        return res;
    }
}
