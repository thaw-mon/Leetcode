package Year2019.July.day17;

import java.util.Stack;

/**
 * @题目 ：130. 被围绕的区域
 * @Data: 19/7/31
 * @题目描述： 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * @示例1: ######
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * @示例2: ###
 **/

public class SurroundedRegions {

    //类似于围棋的黑白吃子
    //这道题关键要明白只有和边界的O联通的O才是不可被替换掉的
    //要找到和边界O联通的O，采用DFS或BFS方法
    public void solve(char[][] board) {
        int row = board.length;
        if(row==0) return;
        int column = board[0].length;
        Stack<Character> stack = new Stack<>();
        //按行遍历首部和尾部
        for (int j = 0; j < column; j++) {
            //进行DFS
            if (board[0][j] == 'O')
                DFS(board, 0, j);
            if (board[row - 1][j] == 'O')
                DFS(board, row - 1, j);
        }
        //按列遍历首部和尾部
        for (int i = 1; i < row - 1; i++) {
            //进行DFS
            if (board[i][0] == 'O')
                DFS(board, i, 0);
            if (board[i][column - 1] == 'O')
                DFS(board, i, column - 1);
        }

        //将修改为E的改为O 而O改为X
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'E')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }

    }

    //采取上下左右的遍历方式-->遍历过的节点设置为E
    private void DFS(char[][] board, int i, int j) {
        //递归结束条件-->到达边界或已经访问过
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'E' || board[i][j] == 'X')
            return;

        board[i][j] = 'E';
        DFS(board, i - 1, j); //上
        DFS(board, i + 1, j); //下
        DFS(board, i, j - 1); //左
        DFS(board, i, j + 1); //右

    }
}
