package Year2020.April.day10;

public class Demo02 {

    /**
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        if (row == 0) return nums;
        int column = nums[0].length;
        if (row * column != r * c) return nums;
        int[][] ret = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = nums[index / column][index % column];
                index++;
            }
        }
        return ret;
    }
}
