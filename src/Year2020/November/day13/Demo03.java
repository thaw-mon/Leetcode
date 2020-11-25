package Year2020.November.day13;

import java.util.Scanner;

public class Demo03 {

    /**
     * 功能:等差数列 2，5，8，11，14。。。。
     * 输入:正整数N >0
     * 输出:求等差数列前N项和
     * 本题为多组输入，请使用while(cin>>)等形式读取数据
     * ret = (2 + 3N-1) * N / 2
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            System.out.println((3 * k + 1) * k / 2);
        }
        scanner.close();
    }
}
