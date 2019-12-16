package June.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：54. 螺旋矩阵
 * @题目描述： 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * @Date:19/6/29
 * @示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * @示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 **/
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] nums = {{3},{2}};
        System.out.println(new SpiralMatrix().spiralOrder(nums));
    }
    // n==1 或m==1时会产生重复输出 需要专门提出来
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        //顺时针遍历外圈
        int i = 0, j = 0;
        int m1=m,n1=n;
        while (i < m1 && j < n1) {
            //只有一行
            if(m1-i==1){
                for(;j<n1;j++){
                    res.add(matrix[i][j]);
                }
                break;
            }
            //只有一列
            if(n1-j==1){
                for(;i<m1;i++){
                    res.add(matrix[i][j]);
                }
                break;
            }
            for (; j < n1 -1; j++) {
                res.add(matrix[i][j]);
            }
            // i = 0 j = n1-1
            for (; i < m1-1; i++) {
                res.add(matrix[i][j]);
            }
            // i = m1-1 j = n1 -1
            for (; j > n-n1; j--) {
                res.add(matrix[i][j]);
            }
            // i = n-1 j = 0
            for (; i >= m-m1+1; i--) {
                res.add(matrix[i][j]);
            }
            i++;j++;
            m1--;n1--;
        }
        return res;
    }
}
