package Year2020.October.day10;

import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args){
        Demo02 demo02 = new Demo02();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(demo02.countDifferCharNumber(s));
    }

    /**
     * 编写一个函数，计算字符串中含有的不同字符的个数。
     * 字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。
     * 不在范围内的不作统计。多个相同的字符只计算一次
     */

    public int countDifferCharNumber(String str) {
        boolean[] flag = new boolean[128];
        int count = 0, asc = 0;
        for (char c : str.toCharArray()) {
            asc = (int) c;
            if (asc >= 128) continue;
            if (!flag[asc]) {
                count++;
                flag[asc] = true;
            }
        }
        return count;
    }
}
