package Year2020.November.day07;

import java.util.Scanner;

public class Demo01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int[][] matrix1 = new int[x][y];
            int[][] matrix2 = new int[y][z];
            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++)
                    matrix1[i][j] = scanner.nextInt();
            for (int i = 0; i < y; i++)
                for (int j = 0; j < z; j++)
                    matrix2[i][j] = scanner.nextInt();
            int[][] matrix = matrixMultiplication(matrix1, matrix2);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    if (j == z - 1) {
                        System.out.println(matrix[i][j]);
                    } else {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
                //System.out.println();
            }

        }
        scanner.close();
    }


    /**
     * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。
     * 这个矩阵的每个元素是由下面的公式决定的
     */

    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
        int x = matrix1.length;
        int y = matrix1[0].length;
        int z = matrix2[0].length;
        int[][] matrix = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    matrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrix;
    }

}
