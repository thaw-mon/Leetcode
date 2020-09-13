package Year2020.September.day03;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {

    /**
     * 给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。
     * <p>
     * 返回经过一些翻转后，行上所有值都相等的最大行数。
     *
     * @param matrix
     * @return
     */
    //作者：fakerleet
    //        链接：https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows/solution/xun-zhao-ju-you-xiang-tong-de-te-zheng-de-xing-de-/
    //        来源：力扣（LeetCode）
    //        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        boolean firstZero = false;
        int res = 0;
        for (int i = 0, len = matrix.length; i < len; i++) {
            if (matrix[i][0] == 0) {
                firstZero = true;
            } else {
                firstZero = false;
            }
            StringBuilder temp = new StringBuilder();
            for (int j = 0, colLen = matrix[i].length; j < colLen; j++) {
                if (firstZero) {
                    temp.append(matrix[i][j]);
                } else {
                    temp.append((matrix[i][j] ^ 1));
                }
            }
            String tempStr = temp.toString();
            res  = Math.max(map.getOrDefault(tempStr, 0) + 1, res);
            map.put(tempStr, map.getOrDefault(tempStr, 0) + 1);
        }
        return res;
    }
}
