package Year2020.February.day03;

public class Demo01 {
    /**
     * @param board
     * @return 细胞的下一个状态
     * @title board保存的是细胞的当前状态，2-3细胞保持状态 3复活 其余死亡
     */
    public void gameOfLife(int[][] board) {
        int row = board.length;
        if (row == 0) return;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //计数周围获得活细胞数目
                int num = cellNum(board, i, j);
                //细胞状态变化
                // 1 --> 0 : 2
                // 0 --> 1 : -1
                // 1 --> 1 : 1
                // 0 --> 0 : 0
                if (num < 2 || num > 3) {
                    board[i][j] = board[i][j] == 0 ? 0 : 2;
                }
                //细胞复活
                if (num == 3 && board[i][j] == 0)
                    board[i][j] = -1;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == -1)
                    board[i][j] = 1;
                if (board[i][j] == 2)
                    board[i][j] = 0;
            }
        }

    }

    //计数[x,y]周围活细胞的数目
    private int cellNum(int[][] board, int x, int y) {
        int row = board.length;
        int column = board[0].length;
        int ret = 0;

        if (x - 1 >= 0) {
            if (y - 1 >= 0 && board[x - 1][y - 1] > 0) ret++;
            if (board[x - 1][y] > 0) ret++;
            if (y + 1 < column && board[x - 1][y + 1] > 0) ret++;
        }

        if (y - 1 >= 0 && board[x][y - 1] > 0) ret++;
        if (y + 1 < column && board[x][y + 1] > 0) ret++;

        if (x + 1 < row) {
            if (y - 1 >= 0 && board[x + 1][y - 1] > 0) ret++;
            if (board[x + 1][y] > 0) ret++;
            if (y + 1 < column && board[x + 1][y + 1] > 0) ret++;
        }
        return ret;
    }
}
