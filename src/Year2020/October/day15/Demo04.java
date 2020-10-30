package Year2020.October.day15;

import java.util.Scanner;

public class Demo04 {

    public static void main(String[] args) {
        Demo04 demo04 = new Demo04();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(demo04.getRabbit(n));
        }
        sc.close();
    }

    /**
     * 有一只兔子，从出生后第3个月起每个月都生一只兔子，
     * 小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * 思路：很简单的递推公式
     */
    public int getRabbit(int n) {
        int[] rabbit = new int[3]; //
        rabbit[0] = 1;
        for (int i = 1; i < n; i++) {
           rabbit[2] += rabbit[1];
           rabbit[1] = rabbit[0];
           rabbit[0] = rabbit[2];
        }
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            ret += rabbit[i];
        }
        return ret;
    }
}
