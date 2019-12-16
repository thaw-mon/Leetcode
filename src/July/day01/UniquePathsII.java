package July.day01;

/**
 * @题目 ：63. 不同路径 II
 * @题目描述： 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * @Date:19/7/1
 * @示例 1: 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 **/

public class UniquePathsII {

    //这道题和前面的不同,不能直接使用排列组合，需要用动态规划

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) return 0;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < row; i++) {
            //当前位置没有障碍物
            if(obstacleGrid[i][0]==0)
                dp[i][0] = dp[i - 1][0];
        }
        for (int j = 1; j < column; j++) {
            //当前位置没有障碍物
            if(obstacleGrid[0][j]==0)
                dp[0][j] = dp[0][j-1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][column - 1];
    }
}
