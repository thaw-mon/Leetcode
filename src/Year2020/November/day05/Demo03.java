package Year2020.November.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < k - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[k - 1]);

        }
        scanner.close();
    }

    /**
     * 输入n个整数，输出其中最小的k个。
     */
    public static List<Integer> getMinK(int[] arr, int k) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }
}
