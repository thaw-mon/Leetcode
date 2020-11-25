package Year2020.November.day13;

import java.util.Scanner;

public class Demo02 {
    /**
     * 自守数是指一个数的平方的尾数等于该数自身的自然数。
     * 例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
     * 发现：只有以0、1、5、6结尾的才可能是自守数。
     */
    public static int CalcAutomorphicNumbers(int n) {
        /*在这里实现功能*/
        int count = 0;
        for (int i = 0; i < n; i++) {
            int k = i;
            long pow = (long) Math.pow(i, 2);
            boolean flag = true;
            while (k > 0) {
                if (k % 10 != pow % 10) {
                    flag = false;
                    break;
                }
                k /= 10;
                pow /= 10;
            }
            if (flag) {
                // System.out.println(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            System.out.println(CalcAutomorphicNumbers(k));
        }
        scanner.close();
    }

}
