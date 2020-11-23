package Year2020.November.day11;

import java.util.Scanner;

public class Demo02 {

    /**
     * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）
     * 沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
     * ans = C(n,m+n) = C(m,m+n)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(permutation(m, m + n));
        }
        scanner.close();
    }

    public static int permutation(int m, int n) {
        assert n >= m;
        int ret = 1, divide = 1;
        for (int i = 0; i < m; i++) {
            ret *= (n - i);
            divide *= (i + 1);
        }
        ret /= divide;
        return ret;
    }
}
