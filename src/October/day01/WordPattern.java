package October.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ： 290. Word Pattern
 * @Data 19/10/01
 * @题目描述： Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * @题目地址： 链接：https://leetcode-cn.com/problems/word-pattern
 * @示例1: ######
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * @示例2: ###
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * @示例3: ###
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */

public class WordPattern {

    //注意是双向连接
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> reflectMap = new HashMap<>();
        String[] strs = str.split(" ");
        char[] patterns = pattern.toCharArray();
        //长度不一致
        if (strs.length != patterns.length) {
            return false;
        }
        for (int i = 0; i < patterns.length; i++) {
            if(!reflectMap.containsKey(patterns[i]) && !reflectMap.containsValue(strs[i])){
                reflectMap.put(patterns[i],strs[i]);
            }else if(reflectMap.containsKey(patterns[i]) && reflectMap.containsValue(strs[i])){
                if(!reflectMap.get(patterns[i]).equals(strs[i])) return false;
            }else {
                return false;
            }
        }
        return true;
    }
}
