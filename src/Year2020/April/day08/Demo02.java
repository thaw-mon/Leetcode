package Year2020.April.day08;

public class Demo02 {

    /**
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int ret = 0;
        int row = matrix.length;
        if(row ==0) return ret;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //找到全为1的正方形面积
                if (matrix[i][j] == '1') {
                    int i1 = i + 1, j1 = j + 1;
                    boolean flag = true;
                    while (i1 < row && j1 < column) {
                        for (int k = i; k <= i1; k++) {
                            if (matrix[k][j1] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) break;
                        for (int k = j; k <= j1; k++) {
                            if (matrix[i1][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) break;
                        j1++;
                        i1++;
                    }
                    //计算当前矩形面积
                    int area = (i1 - i) * (j1 - j);
                    ret = Math.max(ret,area);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0', '0', '0', '1', '0', '1', '1', '1'}, {'0', '1', '1', '0', '0', '1', '0', '1'}, {'1', '0', '1', '1', '1', '1', '0', '1'}, {'0', '0', '0', '1', '0', '0', '0', '0'}, {'0', '0', '1', '0', '0', '0', '1', '0'}, {'1', '1', '1', '0', '0', '1', '1', '1'}, {'1', '0', '0', '1', '1', '0', '0', '1'}, {'0', '1', '0', '0', '1', '1', '0', '0'}, {'1', '0', '0', '1', '0', '0', '0', '0'}};
        System.out.println(new Demo02().maximalSquare(matrix));
    }
}
