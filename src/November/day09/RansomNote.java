package November.day09;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ： 383. Ransom Note
 * @Data 19/11/25
 * @题目描述： Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * @题目链接： 链接：https://leetcode-cn.com/problems/ransom-note
 * @示例1: ######
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * @示例2: ######
 * @示例3: ###
 */


public class RansomNote {
    //判断ransomNote是否可以由magazine组成
    //优化策略：由于只有小写字母，因此可以使用bucket
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> note = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int value = note.getOrDefault(c, 0) + 1;
            note.put(c, value);
        }
        for (char c : ransomNote.toCharArray()) {
            int value = note.getOrDefault(c, 0);
            if (value == 0)
                return false;
            note.put(c, value - 1);
        }
        return true;
    }
}
