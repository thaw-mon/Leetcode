package Year2020.April.day12;

public class Demo02 {

    /**
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     *
     * @param matrix
     * @return
     */
    //TODO 优化策略 dp可以改为一维的
    public int maximalSquare(char[][] matrix) {
        //基本思路动态规划
        int row = matrix.length;
        if (row == 0) return 0;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    ret = Math.max(dp[i][j], ret);
                    continue;
                }
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ret = Math.max(dp[i][j], ret);
                }
            }
        }
        return ret * ret;
    }

    //同样的DP,维度改为1维的
    public int maximalSquare2(char[][] matrix) {
        //基本思路动态规划
        int row = matrix.length;
        if (row == 0) return 0;
        int column = matrix[0].length;
        int[] dp = new int[column];
        int preV = 0, currentV = 0; //保存未修改的上一层节点
        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                preV = currentV;
                currentV = dp[j];
                if (i == 0 || j == 0) {
                    dp[j] = matrix[i][j] - '0';
                    ret = Math.max(dp[j], ret);
                    continue;
                }
                if (matrix[i][j] == '0')
                    dp[j] = 0;
                else {
                    dp[j] = Math.min(preV, Math.min(dp[j], dp[j - 1])) + 1;
                    ret = Math.max(dp[j], ret);
                }
            }
        }
        return ret * ret;
    }
}
