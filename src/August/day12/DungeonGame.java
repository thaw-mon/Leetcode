package August.day12;

/**
 * @题目 ：174. Dungeon Game
 * @Data: 19/8/20
 * @题目描述： In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * @题目地址： 链接：https://leetcode-cn.com/problems/dungeon-game/
 * Note:
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 * @示例1: ######
 * @示例2: ###
 * @示例3: ###
 **/

public class DungeonGame {

    //求从左上角到右下角需要最小的点数 每一步，只能向右或向下
    // 假设长度为n ,则需要 2*（n-1）步
    // 为了求最小的初始值，可以反过来计算 从右下角到左上角
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;

        int column = dungeon[0].length;
        int[][] dp = new int[row][column];
        //dp值最小为1
        //dp[i][j] = Math.max(Math.min(dp[i+1][j] dp[i][j+1]) - dungeon[i][j]  ,1)
        dp[row - 1][column - 1] = Math.max(1 - dungeon[row - 1][column - 1], 1);

        for (int i = row - 2; i >= 0; i--) {
            dp[i][column - 1] = Math.max(dp[i + 1][column - 1] - dungeon[i][column - 1], 1);
        }
        for (int j = column - 2; j >= 0; j--) {
            dp[row - 1][j] = Math.max(dp[row - 1][j + 1] - dungeon[row - 1][j], 1);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }


    private void helper(int[][] dungeon, int right, int down) {
        int n = dungeon.length;
        if (right == n - 1 && down == n - 1)
            return;


    }
}
