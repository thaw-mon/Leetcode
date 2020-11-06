package Year2020.November.day05;

import java.util.Scanner;

public class Demo05 {
    /**
     * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，
     * 本题目要求输出组成指定偶数的两个素数差值最小的素数对。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            getPrimaryPair(n);
        }
        scanner.close();
    }

    public static void getPrimaryPair(int n) {
        int k = n / 2;
        while (k > 0) {
            if (isPrimary(k) && isPrimary(n - k)) {
                break;
            }
            k--;
        }
        System.out.println(k);
        System.out.println(n - k);
    }

    private static boolean isPrimary(int n) {
        //n<=3时，质数有2和3
        if (n <= 3) {
            return n > 1;
        }
        //当n>3时，质数无法被比它小的数整除
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
