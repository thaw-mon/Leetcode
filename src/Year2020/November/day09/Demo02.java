package Year2020.November.day09;

import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String subStr = scanner.next();
            String str = scanner.next();
            System.out.println(isContainStr(subStr, str));
        }
        scanner.close();
    }

    /**
     * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
     * 如果短字符串的所有字符均在长字符串中出现过，则输出true。否则输出false。
     */

    public static boolean isContainStr(String firstStr, String secondStr) {
        int[] word = new int[26];
        for (char c : secondStr.toCharArray()) {
            word[c - 'a']++;
        }
        for (char c : firstStr.toCharArray()) {
            if (word[c - 'a'] == 0) return false;
        }
        return true;
    }
}
