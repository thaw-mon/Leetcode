package Year2020.October.day08;

import java.util.Scanner;

public class Demo01 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Demo01 demo01 = new Demo01();
        System.out.println(demo01.getLastWordLen(str));
    }

    /**
     * 计算字符串最后一个单词的长度，单词以空格隔开。
     * 注意带空格的字符串输入要使用 nextLine
     */

    public int getLastWordLen(String str) {
        int n = str.length();
        int index = n - 1;
        //1.去重尾部多余空格
        while (index >= 0) {
            if (str.charAt(index) == ' ') {
                index--;
                continue;
            }
            break;
        }
        //2.搜索最后一个单词的长度
        int count = 0;
        while (index >= 0) {
            if (str.charAt(index) == ' ') {
                break;
            }
            count++;
            index--;
        }
        return count;
    }
}
