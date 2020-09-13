package Year2020.April.day07;

import java.util.*;

public class Demo02 {

    /**
     * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
     * 段落中的单词不区分大小写。答案都是小写字母。
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> maps = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        int index = 0, maxCount = 0;
        String ret = "";  //返回结果
        int n = paragraph.length();
        while (index < n) {
            //判定是否为字符
            if (!isWord(paragraph.charAt(index))) {
                index++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (index < n && isWord(paragraph.charAt(index))) {
                sb.append(paragraph.charAt(index));
                index++;
            }
            String key = sb.toString().toLowerCase();
            if (!bannedSet.contains(key)) {
                if (!maps.containsKey(key)) {
                    maps.put(key, 0);
                }
                int value = maps.get(key);
                maps.put(key, value + 1);
                if (value + 1 > maxCount) {
                    maxCount = value + 1;
                    ret = key;
                }
            }
        }
        return ret;
    }

    private boolean isWord(char tmp) {
        return (tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z');
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(new Demo02().mostCommonWord(paragraph, banned));
    }
}
