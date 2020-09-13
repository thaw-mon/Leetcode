package Year2019.June.day15;

/**
 * @题目 ：48. 旋转图像
 * @题目描述： 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * @Date:19/6/27 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * @示例 1: 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * @示例 2: 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 */
public class RotateImage {

    //思路：外层转圈后进入内层 四个数转一个圈
    //-->最外层
    //a[0][0] --> a[0][n-1] --> a[n-1][n-1] --> a[n-1]a[0] -->a[0][0]  + + - -
    //a[0][1] --> a[1][n-1] --> a[n-1][n-2] --> a[n-2][0] --> a[0][1]
    //a[0][i] -->a[i][n-1] -->a[n-1][n-1-i] --> a[n-1-i][0] -->a[0][i]
    //a[0][n-2]--> a[n-2][n-1] -->a[n-1][1] --> a[1][0]   --> a[0][n-2]
    //
    public static void main(String[] args) {
        int[][] nums ={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}} ;
        new RotateImage().rotate(nums);
        for(int i=0; i<nums.length;i++){
            for(int j = 0; j<nums.length;j++){
                System.out.print(nums[i][j] +" ");
            }
            System.out.println();
        }
    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
//            int size = n - i * 2; //内层矩阵的大小;
            for (int j = i; j < n - 1 - i; j++) {
                //进行一圈4个数字的交换
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;

                //内层 size  (i,i)-->(0,0)
                // (i,j) -->(0,j-i)
                //(0,j-i)  -->(j-i,size-1) -->(size -1 ,size -1 -j+i) -->(size-1-j+i,0)
                //加上(i,i) ==>(i,j) ==>(j,size+i-1) ==>(size+i-1,size+2i-1-j)==>(size+2i-1-j,i)
                //size = n-i*2;
                //==>(i,j) ==>(j,n-i-1)==>(n-i-1,n-1-j)==>(n-1-j,i)
            }
        }
    }

}
