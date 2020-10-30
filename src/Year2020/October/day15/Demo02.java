package Year2020.October.day15;

import java.util.Scanner;

public class Demo02 {

    /**
     * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
     * <p>
     * 例如，当输入5时，应该输出的三角形为：
     * [0,0] [1,0] [0,1] [2,0] [1,1] [0,2]
     * 1 3 6 10 15
     * 2 5 9 14
     * 4 8 13
     * 7 12
     * 11
     */
    //1.暴力求解法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            //1.定义N*N矩阵
            int[][] matrix = new int[N][N];
            //2.对矩阵赋值
            int index = 1;
            for (int k = 0; k < N; k++) {
                for (int i = k; i >= 0; i--) {
                    matrix[i][k - i] = index++;
                }
            }
            //打印结果
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - i; j++) {
                    if (j == N - i - 1) {
                        System.out.println(matrix[i][j]);
                    } else
                        System.out.print(matrix[i][j] + " ");
                }
            }
        }
        sc.close();
    }

    //2.寻找规律法
    //第一行最右上角的元素=(N^2+N) /2
    //第一行其他元素= (j^2 + j) / 2
    //第二行的元素为上一行元素去掉第一个，再减去1即可
    //类似，下一行等于上一行元素去掉第一个，再减去1即可 直到最后
}
