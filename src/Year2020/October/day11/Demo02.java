package Year2020.October.day11;

import java.util.Scanner;

public class Demo02 {


    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(demo02.countOne(num));
    }

    /**
     * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
     */
    public int countOne(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 0x01) == 1) count++;
            num >>= 1;
        }
        return count;
    }
}
