package Year2020.November.day01;

import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args){
        Demo03 demo03 = new Demo03();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s  = scanner.nextLine();
            demo03.countWord(s);
        }
        scanner.close();
    }
    /**
     * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
     * 本题包含多组输入。
     */
    public void countWord(String s) {
        int[] count = new int[4];
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count[0]++;
            } else if (c == ' ') {
                count[1]++;
            } else if (c >= '0' && c <= '9') {
                count[2]++;
            } else
                count[3]++;
        }
        //打印结果
        for (int i = 0; i < 4; i++) {
            System.out.println(count[i]);
        }
    }
}
