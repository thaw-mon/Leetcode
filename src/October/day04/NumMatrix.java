package October.day04;

/**
 * @题目 ： 304. Range Sum Query 2D - Immutable
 * @Data 19/10/09
 * @题目描述： Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * @题目地址： 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * @示例1: ######
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * @示例2: ######
 * @示例3: ###
 */

public class NumMatrix {
    private int[][] matrixDp;

    // matrixDp[i][j] = 以(0,0)为左上角;(i,j)为右下角的矩阵和
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        matrixDp = new int[m + 1][n + 1]; //增加一行和一列的目的是为了减少后面0判断

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixDp[i + 1][j + 1] = matrixDp[i][j + 1] + matrixDp[i + 1][j] - matrixDp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return matrixDp[row2 + 1][col2 + 1] - matrixDp[row1][col2 + 1] - matrixDp[row2 + 1][col1] + matrixDp[row1][col1];
    }
}
