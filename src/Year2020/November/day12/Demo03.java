package Year2020.November.day12;

import java.util.Scanner;

public class Demo03 {
    /**
     * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
     * 注意0值，不属于负数也不属于正数
     */

    public static void getAvgNums(int[] nums) {
        int sum = 0, count = 0, k = 0;
        for (int num : nums) {
            if (num > 0) {
                sum += num;
                k++;
            } else if (num < 0) {
                count++;
            }

        }

        double avg = 0.0;
        if (k > 0) {
            avg = 1.0 * sum / k;
        }
        System.out.printf("%d %.1f\n", count, avg);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = scanner.nextInt();
            getAvgNums(nums);
        }
        scanner.close();
    }
}
