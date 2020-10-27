package Year2020.October.day12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Demo03 demo03 = new Demo03();
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(demo03.transportStr(str));
        }
    }

    /**
     * 编写一个程序，将输入字符串中的字符按如下规则排序。
     * <p>
     * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
     * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     * 规则 3 ：非英文字母的其它字符保持原来的位置。
     */

    public String transportStr(String str) {
        //1.分离出全部的字母
        List<Character> list = new ArrayList<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                list.add(c);
            }
        }
        //对list按照规则排序
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                char c1 = o1.charValue();
                char c2 = o2.charValue();
                if (c1 >= 'a') c1 -= 32;
                if (c2 >= 'a') c2 -= 32;
                return c1 - c2;
            }
        });

        //
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                arr[i] = list.get(index++);
            }
        }

        return new String(arr);
    }
}
