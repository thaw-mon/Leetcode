package Year2020.April.day03;

import java.util.Scanner;

public class Main2 {

    //TODO 超时了，待优化
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, M; //分别为数量和整除数
        N = in.nextInt();
        M = in.nextInt();
        int[] arr = new int[N];  //被整除数
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        //判定一个区间的和是否可以被M整除
        int count = 0;
        int preSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i == j)
                    preSum = arr[i] % M;
                else
                    preSum = (preSum + arr[j]) % M;
                if (preSum == 0) count++;
            }
        }
        System.out.println(count);
    }
}
