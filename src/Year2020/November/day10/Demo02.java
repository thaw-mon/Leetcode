package Year2020.November.day10;

import java.util.Scanner;

public class Demo02 {
    /**
     * 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
     */
    public static int countLoopOne(int num) {
        int maxCount = 0, count = 0;
        while (num != 0) {
            int bit = num & 1;
            if (bit == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
            num >>>= 1;
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(countLoopOne(n));
        }
        scanner.close();
    }
}
