package Year2020.November.day04;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            System.out.println(getAnswer(k));
            System.out.println(getAnswer2(k));
        }
    }

    /**
     * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
     * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
     */
    public static int getAnswer(int k) {
        int[] arr = new int[2 * k - 1];
        arr[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 2 * i - 2; j >= 2; j--) {
                arr[j] += (arr[j - 1] + arr[j - 2]);
            }
            if (2 * i - 1 > 1)
                arr[1] = (i - 1);

        }
        for (int i = 0; i < 2 * k - 1; i++) {
            if (arr[i] % 2 == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    //通过对比发现结果属于2-4,因此只需要找出2-4列的规律
    public static int getAnswer2(int k) {
        //2 ==> 0 1 2 3 4 5  ... n-1
        //3 ==> 0 1 3 6 10 15 21 ...  n(n-1)/2 (n>=2)
        //4 ==> 0 0 2 7 16 30 53[5,9,14,23] dp[i] = dp[i-1] + (i+1)(i-2)/2 (i>=3)
        //dp[3]= 2 dp[4] = 2 + 5*2 / 2 = 7 dp[5] = 7+6*3 /2 = 16;
        if (k <= 2) return -1;
        int f2 = k - 1;
        if (f2 % 2 == 0) return 2;
        int f3 = k * (k - 1) / 2;
        if (f3 % 2 == 0) return 3;
        return 4;
       /* int f4 = 2;
        for (int i = 4; i <= k; i++) {
            f4 += (k + 1) * (k - 2) / 2;
        }*/

    }
}
