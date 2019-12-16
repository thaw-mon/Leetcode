package July.day04;

/**
 * @题目 ：74. 搜索二维矩阵
 * @题目描述： 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @Date:19/7/4
 * @示例 1: 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * @示例 2: 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 **/

public class Search2dMatrix {

    //时间复杂度O(M+N)  ==》可优化为O(logM + logN)
    //注意判断[[]]情形
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if(n==0){
            return false;
        }
        int i;
        //先判断在哪一行，再判断再那一列
        for (i = 0; i < m; i++) {
            if (matrix[i][0] == target) {
                return true;
            } else if (matrix[i][0] > target) {
                break;
            }
        }
        if(i==0){
            return false;
        }
        // i-1行为目标行
        for (int j = 1; j < n; j++) {
            if (matrix[i - 1][j]==target)
                return true;
            else if(matrix[i-1][j] > target){
                return false;
            }
        }
        return false;
    }

    //优化策略O(log(M*N))  ==>二维转一维思路
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/sou-suo-er-wei-ju-zhen-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

}
