package Year2020.September.day11;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return new ArrayList<>();
        int column = matrix[0].length;
        if (column == 0) return new ArrayList<>();
        //使用递归策略
        return printMatrixDp(matrix, 0, 0, row, column);
    }

    //定义起始点和长宽
    private ArrayList<Integer> printMatrixDp(int[][] matrix, int x, int y, int row, int column) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (row == 0 || column == 0) return ret; //返回null
        if (row == 1) {
            for (int i = 0; i < column; i++) {
                ret.add(matrix[x][y++]);
            }
            return ret;
        }
        if (column == 1) {
            for (int i = 0; i < row; i++) {
                ret.add(matrix[x++][y]);
            }
            return ret;
        }
        //row > 1 && column > 1
        for (int i = 0; i < column - 1; i++) {
            ret.add(matrix[x][y++]);
        }
        for (int i = 0; i < row - 1; i++) {
            ret.add(matrix[x++][y]);
        }
        for (int i = 0; i < column - 1; i++) {
            ret.add(matrix[x][y--]);
        }
        for (int i = 0; i < row - 1; i++) {
            ret.add(matrix[x--][y]);
        }
        x++;
        y++;
        row -= 2;
        column -= 2;
        ret.addAll(printMatrixDp(matrix, x, y, row, column));

        return ret;
    }
}
