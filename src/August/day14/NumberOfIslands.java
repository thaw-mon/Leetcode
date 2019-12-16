package August.day14;

/**
 * @题目 ：200. Number of Islands
 * @Data 19/8/29
 * @题目描述： Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * @题目地址： 链接：https://leetcode-cn.com/problems/number-of-islands
 * @示例1: ######
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * @示例2: ###
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 * @示例3: ###
 */

public class NumberOfIslands {
    public static void main(String[] args){
        char[][] grid = {{'1'},{'1'}};
        new NumberOfIslands().numIslands(grid);
    }

    //本质上是计算连通图的数量
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row==0) return 0;
        int column = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    SearchGraph(grid, i, j);
                }
            }
        return res;
    }

    //从指定地点开始遍历
    private void SearchGraph(char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] == '0') return;
        //遍历该点
        grid[i][j] = '0';

        //上，下，左， 右
        SearchGraph(grid, i - 1, j);
        SearchGraph(grid, i + 1, j);
        SearchGraph(grid, i, j - 1);
        SearchGraph(grid, i, j + 1);
    }

    //并查集思路 : 略

}
