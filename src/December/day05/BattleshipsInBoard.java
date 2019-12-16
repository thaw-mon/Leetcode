package December.day05;

/**
 * @题目 ：419. Battleships in a Board
 * @Data 19/12/10
 * @题目描述： Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * @题目链接： 链接：https://leetcode-cn.com/problems/battleships-in-a-board
 * @示例1: ######
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 * @示例2: ######
 * @示例3: ###
 */


public class BattleshipsInBoard {
    //计算board的数目:如果可以修改board就很简单
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    res++;
                    board[i][j] = '.';
                    //把相连的X该为 .
                    for (int k = i + 1; k < m; k++) {
                        if (board[k][j] == 'X') {
                            board[k][j] = '.';
                            continue;
                        }
                        break;
                    }
                    for (int k = j + 1; k < n; k++) {
                        if (board[i][k] == 'X') {
                            board[i][k] = '.';
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }

    //大佬的优化写法
    //  作者：15214361728
    //    链接：https://leetcode-cn.com/problems/battleships-in-a-board/solution/java-yi-ci-sao-miao-o1kong-jian-by-15214361728/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int countBattleships2(char[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 && (j == 0 || board[i][j - 1] != 'X') || i > 0 && board[i - 1][j] != 'X' && (j == 0 || board[i][j - 1] != 'X')) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }


}
