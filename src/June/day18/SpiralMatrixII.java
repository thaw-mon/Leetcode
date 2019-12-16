package June.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：59. 螺旋矩阵 II
 * @题目描述： 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * @Date:19/6/30
 * @示例 1: 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 **/
//思路：将之前的SpiralMatrix简单改一下就ok了
public class SpiralMatrixII {

    public static void main(String[] args){
        new SpiralMatrixII().generateMatrix2(10);
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        spiralOrder(matrix);
        return matrix;
    }

    //结果正确且通过，但是太慢了,而且还不简洁
    private void spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        //顺时针遍历外圈
        int i = 0, j = 0;
        int m1 = m, n1 = n;
        int k = 1;
        while (i < m1 && j < n1) {
            //只有一行
            if (m1 - i == 1) {
                for (; j < n1; j++) {
                    matrix[i][j] = k++;
                }
                break;
            }
            //只有一列
            if (n1 - j == 1) {
                for (; i < m1; i++) {
                    matrix[i][j] = k++;
                }
                break;
            }
            for (; j < n1 - 1; j++) {
                matrix[i][j] = k++;
            }
            // i = 0 j = n1-1
            for (; i < m1 - 1; i++) {
                matrix[i][j] = k++;
            }
            // i = m1-1 j = n1 -1
            for (; j > n - n1; j--) {
                matrix[i][j] = k++;
            }
            // i = n-1 j = 0
            for (; i >= m - m1 + 1; i--) {
                matrix[i][j] = k++;
            }
            i++;
            j++;
            m1--;
            n1--;
        }
    }

    // 作者：song-19
    //    链接：https://leetcode-cn.com/problems/two-sum/solution/qiao-miao-pan-duan-he-shi-zhuan-xiang-_shi-jian-fu/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //将大佬的python写法改为java
    //思路：用dx,dy来控制x,y的移动  向右:(0,1)  向下(1，0)  相左(0,-1)  向上(-1,0)
    public int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int x = 0, y = 0, dx = 0, dy = 1;  //初始默认向右
        for (int i = 1; i <= n * n; i++) {
            matrix[x][y] = i;
            //巧妙地改变移动方向  (0,1)(1,0)(0,-1)(-1,0)
            if (matrix[(x + dx + n) % n][(y + dy + n) % n] > 0) {
                int tmp = dx;
                dx = dy;
                dy = -tmp;
            }
            x += dx;
            y += dy;
        }
        return matrix;
    }
//    def generateMatrix(self, n):
//    ans = [[0] * n for _ in range(n)]
//    x, y, dx, dy = 0, 0, 0, 1
//            for i in range(1, n * n + 1):
//    ans[x][y] = i
//            if ans[(x + dx) % n][(y + dy) % n] > 0:
//    dx, dy = dy, -dx
//    x, y = x + dx, y + dy
//        return ans


}
