package Year2019.December.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：417. Pacific Atlantic Water Flow
 * @Data 19/12/10
 * @题目描述： Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * @题目链接： 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * @示例1: ######
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * @示例2: ######
 * @示例3: ###
 */

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(matrix));
    }

    //题意是指节点node通过水流
    // 既可以到达左上侧，又可以到达右下侧（DFS）
    //使用逆序DFS,判断哪些节点属于同时可以有大西洋和太平洋可达
    private int[][] matrix_info;
    private int[][] canFlow; //指示信号表示是否可以流入
    // 1表示可以由太平洋流入 2表示可以由大西洋流入 3表示both
    //这道题也要注意空矩阵啊
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();

        int m = matrix.length;
        if(m==0) return res;
        int n = matrix[0].length;  // m*n
        if(n==0) return res;
        canFlow = new int[m][n];
        matrix_info = matrix;
        //1.太平洋DFS
        for (int j = 0; j < n; j++)
            DFS(0, j, 1);
        for (int i = 1; i < m; i++)
            DFS(i, 0, 1);
        //2.大西洋DFS
        for (int j = 0; j < n; j++)
            DFS(m - 1, j, 2);
        for (int i = 0; i < m - 1; i++)
            DFS(i, n - 1, 2);
        //3.获取最后的结果
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (canFlow[i][j] == 3) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    res.add(ans);
                }
            }
        return res;
    }

    //flag指示有哪个洋流入
    private void DFS(int x, int y, int flag) {
        canFlow[x][y] |= flag;
        //上，下，左，右
        if (x - 1 >= 0 && matrix_info[x - 1][y] >= matrix_info[x][y] && (canFlow[x - 1][y] & flag) == 0)
            DFS(x - 1, y, flag);
        if (x + 1 < matrix_info.length && matrix_info[x + 1][y] >= matrix_info[x][y] && (canFlow[x + 1][y] & flag) == 0)
            DFS(x + 1, y, flag);
        if (y - 1 >= 0 && matrix_info[x][y - 1] >= matrix_info[x][y] && (canFlow[x][y - 1] & flag) == 0)
            DFS(x, y - 1, flag);
        if (y + 1 < matrix_info[0].length && matrix_info[x][y + 1] >= matrix_info[x][y] && (canFlow[x][y + 1] & flag) == 0)
            DFS(x, y + 1, flag);
    }
}
