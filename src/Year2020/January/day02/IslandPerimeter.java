package Year2020.January.day02;

/**
 * @题目 ：463. Island Perimeter
 * @Data 20/01/07
 * @题目描述： TYou are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * @题目链接： 链接：https://leetcode-cn.com/problems/island-perimeter
 * @示例1: ######
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Output: 16
 * @示例2: ######
 * @示例3: ###
 */

public class IslandPerimeter {

    //计算1围成图形的周长。很简单判断1的周围是不是0,是0则加1
    //优化策略：判断上和左就够了 然后乘2
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //判断四周
                    //1.上
                    if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                    //2.下
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) perimeter++;
                    //3.左
                    if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                    //4.右
                    if (j == grid[i].length - 1 || grid[i][j + 1] == 0) perimeter++;
                }
            }
        }
        return perimeter;
    }
}
