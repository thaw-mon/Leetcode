package Year2020.October.day10;

import java.util.Scanner;

public class Demo04 {

    public static void main(String[] args){
        Demo04 demo03 = new Demo04();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(demo03.getReverseStr(s));

    }

    /**
     * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     */

    public String getReverseStr(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }
}
