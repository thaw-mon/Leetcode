package Year2020.October.day15;

import java.util.Arrays;
import java.util.Scanner;

public class Demo01 {

    /**
     * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。
     * 请大家给Lily帮忙，通过C语言解决。
     * 本题含有多组样例输入。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            System.out.println(cs);
        }
        sc.close();
    }
}
