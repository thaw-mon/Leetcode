package Year2020.November.day05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.next();
            firstAppearChar(s);
        }
        scanner.close();
    }

    /**
     * 找出字符串中第一个只出现一次的字符
     */
    public static void firstAppearChar(String s) {
        int[] word = new int[26];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            word[c - 'a']++;
            if (!indexMap.containsKey(c - 'a')) indexMap.put(c - 'a', i);
        }
        int index = s.length();
        for (int i = 0; i < 26; i++) {
            if (word[i] == 1 && indexMap.get(i) < index) { //仅出现一次
                index = indexMap.get(i);
            }
        }
        if (index == s.length()) {
            System.out.println(-1);
        } else
            System.out.println(s.charAt(index));
    }
}
