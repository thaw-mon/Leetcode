package Year2020.March.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(new Demo01().findSubstring(s, words));
    }

    /**
     * 给定一个字符串 s 和一些长度相同的单词 words。
     * 找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     * 勉强通过
     * @param s     ： 给定一个字符串
     * @param words ：长度相同的单词
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length; // N!个排列方式啊
        if(n==0) return new ArrayList<>();
        int baseLen = words[0].length(); //单词的长度

        //1.获取单词Map
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        //3.同过判断首部单词组成的子串进行判断,子串不一定是以第一个单词开头开始的啊
        List<Integer> ret = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i + n * baseLen > len) {
                break;
            }
            if (!wordMap.containsKey(s.substring(i, i + baseLen))) {
                continue;
            }
            Map<String, Integer> tmpMap = new HashMap<>(wordMap);
            int start = i;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                String str = s.substring(start, start + baseLen);
                int value = tmpMap.getOrDefault(str, 0);
                if (value == 0) {
                    flag = false;
                    break;
                }
                tmpMap.put(str, value - 1);
                start += baseLen;
            }
            if (flag) ret.add(i);
        }
        return ret;
    }
}
