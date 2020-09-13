package Year2020.September.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo03 {

    /**
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *
     * @param s
     * @param words
     * @return
     */
    //耗时较长，勉强通过
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        int size = words.length;
        int len = words[0].length();
        List<Integer> ret = new ArrayList<>();
        //TODO 待优化
        for (int i = 0; i < s.length(); i++) {
            if (isSubString(s, i, wordMap, len, size)) {
                ret.add(i);
            }
        }
        return ret;
    }

    private boolean isSubString(String s, int start, Map<String, Integer> wordMap, int len, int size) {
        Map<String, Integer> tmpWordMap = new HashMap<>();
        int count = 0;
        for (int i = start; i + len < s.length(); i += len) {
            //if (start + len > s.length()) return false;
            String sub = s.substring(i, i + len);
            if (!wordMap.containsKey(sub)) return false;
            tmpWordMap.put(sub, tmpWordMap.getOrDefault(sub, 0) + 1);
            int val = tmpWordMap.get(sub);
            if (val > wordMap.get(sub)) return false; //不连贯
            count++;
            if (count == size) break;
        }
        //判定是否完全匹配
        return count == size;
    }

    public static void main(String[] args) {
        String s1 = "barfoothefoobarman";
        String[] s = {"bar", "foo"};
        System.out.println(new Demo03().findSubstring(s1, s));
    }
}
