package Year2020.November.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            printResult(getAnswer(k));
        }
        scanner.close();
    }

    public static void printResult(List<Integer> res) {
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.println(res.get(i));
            } else
                System.out.print(res.get(i) + "+");
        }
    }

    /**
     * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
     * 本题含有多组输入数据。
     */
    public static List<Integer> getAnswer(int k) {
        int num = (int) Math.pow(k, 3);
        int base = (int) Math.pow(k, 2);
        //判断base为奇数还是偶数
        List<Integer> result = new ArrayList<>();
        if (k % 2 == 0) {
            for (int i = k / 2 - 1; i >= 0; i--) {
                result.add(base - 1 - 2 * i);
            }
            for (int i = 0; i < k / 2; i++) {
                result.add(base + 1 + 2 * i);
            }

        } else {
            for (int i = k / 2; i >= 0; i--) {
                result.add(base - 2 * i);
            }
            for (int i = 1; i <= k / 2; i++) {
                result.add(base + 2 * i);
            }
        }
        return result;
    }
}
