package July.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：118. 杨辉三角
 * @Data: 19/7/17
 * @题目描述： 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @示例 1：
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * @示例 2: ###
 **/

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        res.add(row1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = res.get(res.size() - 1);
            row.add(1);
            for (int j = 1; j < preRow.size(); j++) {
                row.add(preRow.get(j) + preRow.get(j - 1));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
