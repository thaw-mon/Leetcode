package Year2020.July.Day01;

/**
 * @Title : 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 */
public class Demo01 {
    class NumMatrix {
        int[][] matrixSum; //

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            if(row==0) return;
            int col = matrix[0].length;
            if(col==0) return;
            matrixSum = new int[row + 1][col + 1];
//            matrixSum[i+1][j + 1] = Sum(matrix[..i][..j])

            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    matrixSum[i][j] = matrixSum[i - 1][j] + matrixSum[i][j - 1] - matrixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return matrixSum[row2 + 1][col2 + 1] - matrixSum[row2 + 1][col1] - matrixSum[row1][col2 + 1] + matrixSum[row1][col1];
        }
    }
}
