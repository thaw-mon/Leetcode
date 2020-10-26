package Year2020.October.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo10 {

    public static void main(String[] args){
        Demo10 demo10 = new Demo10();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(demo10.removeLeastChar(s));
        }
    }
    /**
     * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
     * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     * 字符串只包含小写英文字母
     */
    public String removeLeastChar(String s) {
        int[] word = new int[26];
        for (char c : s.toCharArray()) {
            word[c - 'a']++;
        }
        //获取最小数目的字符
        List<Character> cList = new ArrayList<>();
        int minCnt = s.length();
        for (int i = 0; i < 26; i++) {
            if (word[i] == 0) continue;
            if (word[i] < minCnt) minCnt = word[i];
        }
        int base = (int) 'a';
        for (int i = 0; i < 26; i++) {
            if (word[i] == minCnt) cList.add((char) (base + i));
        }
        StringBuilder ret = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (cList.contains(c)) continue;
            ret.append(c);
        }
        return ret.toString();
    }
}
