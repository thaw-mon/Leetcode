package June.day12;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：36. 有效的数独
 * @题目描述： 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示
 * @Date:19/6/24
 * @示例 1: 略
 * 官方解答思路：采用一遍遍历法
 * 子数独 ： box_index = (row / 3) * 3 + columns / 3
 * <p>
 */

public class ValidSudoku {

    //暴力破解法
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> mapLine = new HashMap<>();
        Map<Character, Integer> mapColumn = new HashMap<>();
        //验证行和列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //验证行
                if (board[i][j] != '.') {
                    if (!mapLine.containsKey(board[i][j])) {
                        mapLine.put(board[i][j], 1);
                    } else {
                        return false;
                    }
                }
                //验证列
                if (board[j][i] != '.') {
                    if (!mapColumn.containsKey(board[j][i])) {
                        mapColumn.put(board[j][i], 1);
                    } else {
                        return false;
                    }
                }
            }
            mapLine.clear();
            mapColumn.clear();
        }
        //验证3*3宫格
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                //验证1个3*3宫格
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++){
                        if(board[m+i*3][n+j*3] != '.'){
                            if (!map.containsKey(board[m+i*3][n+j*3])) {
                                map.put(board[m+i*3][n+j*3], 1);
                            } else {
                                return false;
                            }
                        }
                    }
                }
                map.clear();
            }
        return true;
    }
}
