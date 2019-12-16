package June.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：51. N皇后II
 * @题目描述： n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案的数量。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @Date:19/6/28
 * @示例 1:
 * 输入: 4
 * 输出: 2
 **/
public class NQueensII {

    static int res = 0;

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new NQueensII().totalNQueens(n));
    }

    //n皇后问题:横竖和斜线上都不能存在两个皇后
    //优化斜线判断：斜线 行号+列号 和 行号-列号
    public int totalNQueens(int n) {

        //初始化map
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                map[i][j] = '.';
        }
        int[] flag = new int[n];
        int[] biasFlag1 = new int[2 * n - 1];
        int[] biasFlag2 = new int[2 * n - 1];
        queens(map, 0, flag, biasFlag1, biasFlag2);
        return res;
    }

    private void queens(char[][] map, int n, int[] flag, int[] biasFlag1, int[] biasFlag2) {
        int length = map.length;
        //递归退出条件
        if (n == length) {
            res++;
        }
        for (int i = 0; i < length; i++) {
            if (flag[i] != 0 || biasFlag1[n+i] !=0 || biasFlag2[n-i+length-1] != 0)
                continue;
            flag[i] = 1;
            biasFlag1[n+i] = 1;
            biasFlag2[n-i+length-1] = 1;
            map[n][i] = 'Q';
            queens(map, n + 1, flag, biasFlag1, biasFlag2);
            //复原
            flag[i] = 0;
            biasFlag1[n+i] = 0;
            biasFlag2[n-i+length-1] = 0;
            map[n][i] = '.';
        }

    }

    //判断斜线是否存在两个皇后
    private boolean isMatch(char[][] map, int n, int i) {
        int len = map.length;
        int left = i - 1;
        int right = i + 1;
        int j = n - 1;
        for (; j >= 0; j--) {
            if (left < 0 || right >= len) {
                break;
            }
            if (map[j][left--] == 'Q' || map[j][right++] == 'Q') {
                return false;
            }

        }
        while (left >= 0 && j >= 0) {
            if (map[j--][left--] == 'Q')
                return false;
        }
        while (right < len && j >= 0) {
            if (map[j--][right++] == 'Q')
                return false;
        }
        return true;
    }

    //大佬的bitMap思路
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/nhuang-hou-ii-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int backtrack(int row, int hills, int next_row, int dales, int count, int n) {
        /**
         row: 当前放置皇后的行号
         hills: 主对角线占据情况 [1 = 被占据，0 = 未被占据]
         next_row: 下一行被占据的情况 [1 = 被占据，0 = 未被占据]
         dales: 次对角线占据情况 [1 = 被占据，0 = 未被占据]
         count: 所有可行解的个数
         */

        // 棋盘所有的列都可放置，
        // 即，按位表示为 n 个 '1'
        // bin(cols) = 0b1111 (n = 4), bin(cols) = 0b111 (n = 3)
        // [1 = 可放置]
        int columns = (1 << n) - 1;

        if (row == n)   // 如果已经放置了 n 个皇后
            count++;  // 累加可行解
        else {
            // 当前行可用的列
            // ! 表示 0 和 1 的含义对于变量 hills, next_row and dales的含义是相反的
            // [1 = 未被占据，0 = 被占据]
            int free_columns = columns & ~(hills | next_row | dales);

            // 找到可以放置下一个皇后的列
            while (free_columns != 0) {
                // free_columns 的第一个为 '1' 的位
                // 在该列我们放置当前皇后
                int curr_column = - free_columns & free_columns;

                // 放置皇后
                // 并且排除对应的列
                free_columns ^= curr_column;

                count = backtrack(row + 1,
                        (hills | curr_column) << 1,
                        next_row | curr_column,
                        (dales | curr_column) >> 1,
                        count, n);
            }
        }

        return count;
    }
    public int totalNQueens2(int n) {
        return backtrack(0, 0, 0, 0, 0, n);
    }

}
