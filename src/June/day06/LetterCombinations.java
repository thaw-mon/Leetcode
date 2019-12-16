package June.day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Data 19/6/5
 * @题目描述： 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @示例： 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("12"));

    }

    //递归方法
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        Character tmp = digits.charAt(0);
        for (Character c : map.get(tmp).toCharArray()) {
            if (digits.substring(1).isEmpty()) {
                res.add(c.toString());
                continue;
            }
            for (String s : letterCombinations(digits.substring(1))) {
                StringBuilder str = new StringBuilder();
                str.append(c).append(s);
                res.add(str.toString());
            }
        }
        return res;
    }
}
