package Year2020.October.day10;

import java.util.Scanner;

public class Demo01 {


    public static void main(String[] args){
        Demo01 demo01 = new Demo01();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(demo01.getNoLoopNum(num));
    }
    /**
     * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     */

    public int getNoLoopNum(int num) {
        boolean[] flag = new boolean[10];
        int ret = 0;
        while (num > 0) {
            int currentNum = num % 10;
            if (!flag[currentNum]) {
                ret *= 10;
                ret += currentNum;
                if (ret > 0) flag[currentNum] = true;
            }
            num /= 10;
        }
        return ret;
    }
}
