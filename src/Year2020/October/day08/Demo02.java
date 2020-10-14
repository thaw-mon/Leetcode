package Year2020.October.day08;

import java.util.Scanner;

public class Demo02 {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = (char) scanner.next().charAt(0);
        System.out.println(new Demo02().countChar(str,c));
    }
    /**
     * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。
     * 不区分大小写。
     */

    public int countChar(String str, char c) {
        char c1 = c;
        if (c >= 'A' && c < 'Z') {
            c1 += 32;
        } else if (c >= 'a' && c < 'z') {
            c1 -= 32;
        }
        int count = 0;
        for (char s : str.toCharArray()) {
            if (s == c || s == c1) count++;
        }
        return count;
    }

    //1.
    private boolean isLetters(char c) {
        return (c >= 'A' && c < 'Z') || (c >= 'a' && c < 'z');
    }
}
