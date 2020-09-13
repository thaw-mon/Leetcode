package Year2020.July.day04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        
        //1.获取输入数组
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }
        //2.递归获取子数组
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j = i; j < array.length; j++) {
                temp += array[j];
                if (temp != 0) count++;
            }
        }
        System.out.println(count);

    }

    //获取以start为开头的连续非0子数组数目
    private int DP(int[] arr, int start) {

        int count = 0;
        int temp = 0;
        for (int i = start; i < arr.length; i++) {
            temp += arr[start];
            if (temp != 0) count++;
        }
        return count;
    }
}
