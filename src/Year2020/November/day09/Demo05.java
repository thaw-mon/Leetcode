package Year2020.November.day09;

import java.util.Scanner;

public class Demo05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(countUpperWord(str));
        }
        scanner.close();
    }

    /**
     * 找出给定字符串中大写字符(即'A'-'Z')的个数。
     */

    public static int countUpperWord(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') count++;
        }
        return count;
    }
}
