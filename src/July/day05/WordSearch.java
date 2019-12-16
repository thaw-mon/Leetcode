package July.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：79. 单词搜索
 * @题目描述： 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * @Date:19/7/5
 * @示例 1: board =
 * [
 * ['A','B','CombineTwoTables','E'],
 * ['S','F','CombineTwoTables','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 **/

public class WordSearch {

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED"; //ABCCED  ABCB
        System.out.println(new WordSearch().exist(board, word));

    }

    //结果是ok，但是居然打败5%,这也太慢了
    //原因分析：主要是使用List作为重复路径判断，不断地add和remove大大拖慢了速度
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) {
            return word.isEmpty();
        }
        int column = board[0].length;
        if (column == 0) {
            return word.isEmpty();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    List<List<Integer>> path = new ArrayList<>();
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    path.add(ans);
                    if (isFit(board, word, path)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //问题：当word字符不变时,会产生一直再原地匹配的问题,需要添加路径防止单词重复使用
    //最开始使用  List<int[]> path 但是contains一直输出false
    private boolean isFit(char[][] board, String word, List<List<Integer>>path) {
        if (word.length() == path.size()) {
            return true;
        }
       List<Integer> place = path.get(path.size() - 1);
        int[][] step = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  //上 右 下 左
        int s1 = board.length;
        int s2 = board[0].length;
        for (int m = 0; m < 4; m++) {
            int tmpi = place.get(0) + step[m][0];
            int tmpj = place.get(1) + step[m][1];
            if (tmpi < 0 || tmpi >= s1 || tmpj < 0 || tmpj >= s2) {
                continue;
            }
            List<Integer> nextPath = new ArrayList<>();
            nextPath.add(tmpi);
            nextPath.add(tmpj);
            if (!path.contains(nextPath) && board[tmpi][tmpj] == word.charAt(path.size())) {
                path.add(nextPath);
                if (isFit(board, word, path))
                    return true;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}
