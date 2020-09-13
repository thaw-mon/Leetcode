package Year2020.July.Day01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title : 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 */
public class Demo03 {
    class Point {
        int x;
        int y;
        int k; //记录步长

        Point(int a, int b) {
            x = a;
            y = b;
            k = 0;
        }

        Point(int a, int b, int c) {
            x = a;
            y = b;
            k = c;
        }
    }

    /**
     * 遍历思想 DFS ： 注意斜对角的存在
     *
     * @param grid
     * @return
     */

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length; //注意是个正方形
        Queue<Point> queue = new LinkedList<>();
        if (grid[0][0] == 1 || grid[row - 1][row - 1] == 1) return -1;
        queue.add(new Point(0, 0, 1));
        grid[0][0] = 1; //表示已访问或阻塞
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            int x = tmp.x, y = tmp.y, k = tmp.k;
            if (x == row - 1 && y == row - 1) return k;
            //找8个方向
            //1.上，下，左 右
            if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                grid[x - 1][y] = 1; //设为已经访问
                queue.add(new Point(x - 1, y, k + 1));
            }
            if (x + 1 < row && grid[x + 1][y] == 0) {
                grid[x + 1][y] = 1; //设为已经访问
                queue.add(new Point(x + 1, y, k + 1));
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                grid[x][y - 1] = 1;
                queue.add(new Point(x, y - 1, k + 1));
            }
            if (y + 1 < row && grid[x][y + 1] == 0) {
                grid[x][y + 1] = 1;
                queue.add(new Point(x, y + 1, k + 1));
            }
            //2.上左，上右 ，下左，下右
            if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] == 0) {
                grid[x - 1][y - 1] = 1;
                queue.add(new Point(x - 1, y - 1, k + 1));
            }
            if (x - 1 >= 0 && y + 1 < row && grid[x - 1][y + 1] == 0) {
                grid[x - 1][y + 1] = 1;
                queue.add(new Point(x - 1, y + 1, k + 1));
            }
            if (x + 1 < row && y - 1 >= 0 && grid[x + 1][y - 1] == 0) {
                grid[x + 1][y - 1] = 1;
                queue.add(new Point(x + 1, y - 1, k + 1));
            }
            if (x + 1 < row && y + 1 < row && grid[x + 1][y + 1] == 0) {
                grid[x + 1][y + 1] = 1;
                queue.add(new Point(x + 1, y + 1, k + 1));
            }

        }
        return -1;
    }
}
