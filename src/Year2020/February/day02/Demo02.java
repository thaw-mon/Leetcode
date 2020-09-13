package Year2020.February.day02;

public class Demo02 {

    public static void main(String[] args){
        int n = 6;
        int[][] ret = new Demo02().generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(ret[i][j] + " ");
            System.out.println();
        }
    }
    /**
     * @param n
     * @return
     * @title 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     */
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        //右，下，左，上
        // n/2轮
        int x=0,y=0,index = 1,l = 0, r = n-1;
        while (l <= r){
            //右
            while (y < r && ret[x][y]==0){
                ret[x][y++] = index++;
            }
            //下
            while(x < r && ret[x][y]==0){
                ret[x++][y] = index++;
            }
            //左
            while (y > l && ret[x][y]==0){
                ret[x][y--] = index++;
            }
            //上
            while(x > l && ret[x][y]==0){
                ret[x--][y] = index++;
            }
            x++;
            y++;
            l++;
            r--;
        }
        //n为奇数，最后一个数字没有填入
        if(n % 2 == 1){
            ret[n / 2][n / 2] = index;
        }
        return ret;
    }
}
