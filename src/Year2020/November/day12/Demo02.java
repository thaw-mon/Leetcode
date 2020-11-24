package Year2020.November.day12;

import java.util.Scanner;

public class Demo02 {
    /**
     * 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
     */

    public static String MarkNum(String pInStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pInStr.length(); i++) {
            char c = pInStr.charAt(i);
            if (c >= '0' && c <= '9') { //当前为数字
                if (i == 0 || pInStr.charAt(i - 1) < '0' || pInStr.charAt(i - 1) > '9') {
                    sb.append("*");
                }
            } else {
                if (i > 0 && pInStr.charAt(i - 1) >= '0' && pInStr.charAt(i - 1) <= '9') {
                    sb.append("*");
                }
            }
            sb.append(c);
        }
        if (pInStr.charAt(pInStr.length() - 1) >= '0' && pInStr.charAt(pInStr.length() - 1) <= '9') {
            sb.append("*");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(MarkNum(str));
        }
        scanner.close();
    }

}
