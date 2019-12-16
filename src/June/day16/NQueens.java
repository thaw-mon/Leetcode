package June.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @题目 ：51. N皇后
 * @题目描述： n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @Date:19/6/28
 * @示例 1: 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * <p>
 */

public class NQueens {

    static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        int n = 2;
        new NQueens().solveNQueens(n);
        System.out.println(res.size());
    }

    //n皇后问题:横竖和斜线上都不能存在两个皇后
    //TODO 优化斜线判断：斜线 行号+列号 和 行号-列号
    public List<List<String>> solveNQueens(int n) {

        //初始化map
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                map[i][j] = '.';
        }
        int[] flag = new int[n];
//        int[] biasFlag = new int[4 * n - 2];
        queens(map, 0, flag);
        return res;
    }

    private void queens(char[][] map, int n, int[] flag) {
        int length = map.length;
        //递归退出条件
        if (n == length) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                ans.add(String.valueOf(map[i]));
            }
            res.add(ans);
        }

        for (int i = 0; i < length; i++) {
            if (flag[i] != 0 || !isMatch(map,n,i))
                continue;
            flag[i] = 1;
            map[n][i] = 'Q';
            queens(map, n + 1, flag);
            //复原
            flag[i] = 0;
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
}
