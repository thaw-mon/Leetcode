package November.day05;

import java.util.Set;
import java.util.TreeSet;

/**
 * @题目 ： 363. Max Sum of Rectangle No Larger Than K
 * @Data 19/11/14
 * @题目描述： Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 * @题目链接： 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * @示例1: ######
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 *              and 2 is the max number no larger than k (k = 2).
 * @示例2: ######
 * @示例3: ###
 */
public class MaxSumRectangle {

    public static void main(String[] args) {
        int[][] matrix = {{2, 2, -1}};
        System.out.println(new MaxSumRectangle().maxSumSubmatrix(matrix, 0));
    }

    //     作者：blacksea3
//                链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/c-20-48ms-100-lai-zi-ti-jiao-ji-lu-zhong-de-ju-lao/
//                来源：力扣（LeetCode）
//                著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int res = Integer.MIN_VALUE;
        //前两个for循环，二维转一维
        for (int colStart = 0; colStart < m; colStart++) {
            int[] prerowSum = new int[n];
            for (int colsEnd = colStart; colsEnd < m; colsEnd++) {
                for (int row = 0; row < n; row++) {
                    prerowSum[row] += matrix[row][colsEnd];
                }
                int preSum = 0;
                Set<Integer> sumSet = new TreeSet<>();
                sumSet.add(0); //哨兵值, 如果lower_bound查到了这个值, 说明存在一个从第一行到当前行的矩阵元素和满足条件
                for (int r = 0; r < n; ++r) {
                    preSum += prerowSum[r];
                    for (int val : sumSet) {
                        if (val >= preSum - k) {
                            if (val == preSum - k)
                                return k;
                            res = Math.max(res, preSum - val);
                            break;
                        }
                    }
                    sumSet.add(preSum);
                }
            }
        }

        return res;
    }
}
