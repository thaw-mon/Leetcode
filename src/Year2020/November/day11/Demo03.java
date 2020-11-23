package Year2020.November.day11;

import java.util.Scanner;

public class Demo03 {
    /**
     * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。
     * 如果有相同长度的串，则要一块儿输出（中间不间隔），但是长度还是一串的长度，与数字字符串间用逗号间隔。
     */
    public static String getMaxLenNumStr(String str) {
        String[] arr = str.split("[^0-9]");
        int maxLen = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (s.length() > maxLen) {
                maxLen = s.length();
                sb = new StringBuilder();
                sb.append(s);
            } else if (s.length() == maxLen) {
                sb.append(s);
            }
        }
        sb.append(",").append(maxLen);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(getMaxLenNumStr(s));
        }
        scanner.close();
    }
}
