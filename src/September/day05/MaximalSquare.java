package September.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ： 221. Maximal Square
 * @Data 19/9/07
 * @题目描述： Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * @题目地址： 链接：https://leetcode-cn.com/problems/maximal-square
 * @示例1: ######
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 * @示例2: ###
 * @示例3: ###
 */
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = {{'1', '1', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }

    //求数组中最大的正方形-->动态规划思路:通过了,但是很慢，需要优化
//  公式 : dp[j]=min(dp[j-1],dp[j],prev) + 1
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int column = matrix[0].length;
        if (column == 0) return 0;

        int res = 0, prev = 0;
        int[] dp = new int[column + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int temp = dp[j + 1];
                if (matrix[i][j] == '1') {
                    dp[j + 1] = Math.min(Math.min(dp[j], prev), dp[j + 1]) + 1;
                    res = Math.max(dp[j + 1], res);
                } else
                    dp[j + 1] = 0;
                prev = temp;
            }
        }
        return res * res;
    }
}
