package Year2020.November.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n1 = scanner.nextInt();
            int[] arr1 = new int[n1];
            for (int i = 0; i < n1; i++) arr1[i] = scanner.nextInt();
            int n2 = scanner.nextInt();
            int[] arr2 = new int[n2];
            for (int i = 0; i < n2; i++) arr2[i] = scanner.nextInt();
            print(mergeArray(arr1,arr2));
        }
        scanner.close();
    }

    public static void print(List<Integer> nums) {
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }

    /**
     * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
     * 输出时相邻两数之间没有空格。
     */
    public static List<Integer> mergeArray(int[] arr1, int[] arr2) {
        int N1 = arr1.length, N2 = arr2.length;
        List<Integer> res = new ArrayList<>();
        int i1 = 0, i2 = 0;
        int preNum = Integer.MIN_VALUE;
        while (i1 < N1 && i2 < N2) {
            if (arr1[i1] < arr2[i2]) {
                //选择arr1;
                if (arr1[i1] > preNum) {
                    res.add(arr1[i1]);
                    preNum = arr1[i1];
                }
                i1++;
            } else {
                //选择i2
                if (arr2[i2] > preNum) {
                    res.add(arr2[i2]);
                    preNum = arr2[i2];
                }
                i2++;
            }
        }
        while (i1 < N1) {
            if (arr1[i1] > preNum) {
                res.add(arr1[i1]);
                preNum = arr1[i1];
            }
            i1++;
        }
        while (i2 < N2) {
            if (arr2[i2] > preNum) {
                res.add(arr2[i2]);
                preNum = arr2[i2];
            }
            i2++;
        }
        return res;
    }
}
