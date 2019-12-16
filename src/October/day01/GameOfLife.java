package October.day01;

/**
 * @题目 ： 289. Game of Life
 * @Data 19/10/01
 * @题目描述： 太长了，略
 * @题目地址： 链接：https://leetcode-cn.com/problems/game-of-life/
 * @示例1: ######
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * @示例2: ###
 * @示例3: ###
 */


public class GameOfLife {
    //可以分为三种情形:
    //1. 2个保持状态; 2. 3个全部为状态1; 3.其他全部为状态0
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        //记录位置周围活着细胞数目
        int[][] dp = new int[m][n];
        //初始化dp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = numOfLife(board,i,j);
            }
        }

        //根据dp修改board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j] < 2 || dp[i][j] > 3){
                    board[i][j] = 0;
                }else if(dp[i][j] == 3)
                    board[i][j] = 1;
                //其余保持状态不变
            }
        }

    }

    //2. 大佬的 原地标记算法
//        作者：ChopinXBP
//    链接：https://leetcode-cn.com/problems/game-of-life/solution/ren-sheng-ku-duan-de-yuan-di-biao-ji-suan-fa-java0/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//    第一个循环用于标记，第二个循环用于赋值。
//    1——保持1  -1——1转0   0——保持0  -2——0转1
    public void gameOfLife2(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = checkLoc(board, i, j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }
    }

    public int checkLoc(int[][] board, int i, int j){
        int count = 0;
        int left = Math.max(j - 1, 0);
        int right = Math.min(j + 1, board[i].length - 1);
        int top = Math.max(i - 1, 0);
        int bottom = Math.min(i + 1, board.length - 1);
        for(int x = top; x <= bottom; x++){
            for(int y = left; y <= right; y++){
                count = board[x][y] == 1 || board[x][y] == -1 ? count + 1 : count;
            }
        }
        return board[i][j] == 1 ? (count == 3 || count == 4 ? 1 : -1) : (count == 3 ? -2 : 0);
    }


    //计算周围活着细胞数目
    private int numOfLife(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int m1 = i - 1; m1 <= i + 1; m1++) {
            //m越界情形
            if (m1 < 0 || m1 >= m) continue;
            for (int n1 = j - 1; n1 <= j + 1; n1++) {
                //n越界情形
                if (n1 < 0 || n1 >= n) continue;
                count += board[m1][n1];
            }
        }

        return count-board[i][j];
    }

}
