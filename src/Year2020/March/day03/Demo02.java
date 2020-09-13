package Year2020.March.day03;

public class Demo02 {

    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        //找矩阵中的目标值
        int row = matrix.length;
        if(row==0) return false;
        int column = matrix[0].length;
        if(column ==0) return false;
        for(int i=0;i<row;i++){
            if(matrix[i][0] > target) return false;
            //直接进入下一行
            if(i < row-1 && matrix[i+1][0] < target) continue;

            //target在本行
            for(int j=0;j<column;j++){
                if(matrix[i][j] > target) return false;
                else if(matrix[i][j]==target) return true;
            }
        }
        return false;
    }
}
