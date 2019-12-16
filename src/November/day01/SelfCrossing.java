package November.day01;

/**
 * @题目 ： 335. Self Crossing
 * @Data 19/11/06
 * @题目描述： You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.
 * <p>
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 * @题目链接： 链接：https://leetcode-cn.com/problems/self-crossing
 * @示例1: ######
 * Input: [2,1,1,2]
 * Output: true
 * @示例2: ######
 * Input: [1,2,3,4]
 * Output: false
 * @示例3: ###
 * Input: [1,1,1,1]
 * Output: true
 */

public class SelfCrossing {
    public static void main(String[] args){
        int[] x  ={3,3,3,2,1,1};
        new SelfCrossing().isSelfCrossing(x);
    }
    //判断路径是否相交：行走方向为北、西、南、东的逆时针
    //长度小于4-->绝对不相交
    // len = 4 --> 4 和 1   x[3]>=x[1] && x[2]<=x[0]
    // len = 5 --> 5 和 2、1 x[4]>=x[2] && x[3]<=x[1] || x[4]+x[0]>=x[2] && x[1]=x[3]
    // len = 6 --> 6 和 3、 2、 1 x[5]>=x[3] &&x[4]<=x[2] || x[5]+x[1]>=x[3] && x[2]=x[4] || x[5]+x[1]>=x[3] && x[4]+x[0]>=x[2]
    // len = 7 --> 7 和4 3 2
    // 1--> x[i] >= x[i-2] && x[i-1]<=x[i-3]
    // 2--> x[i]+x[i-4]>=x[i-2] && x[i-1]=x[i-3]
    // 3--> x[i]+x[i-4]>=x[i-2] && x[i-1]+x[i-5]>=x[i-3]
    public boolean isSelfCrossing(int[] x) {
        //获取数组长度
        int step = x.length;
        if (step < 4) return false;
        for (int i = 3; i < step; i++) {
            if(isCross(x,i)){
                return true;
            }
        }
        return false;
    }

    //判断两条线是否存在交点
    boolean isCross(int[] x, int i) {
        boolean res = false;
        //三种情形
        if (i < 3) return false;
        //1--> x[i] >= x[i-2] && x[i-1]<=x[i-3]
        if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
            res = true;
        }
        if (i == 3) return res;
        // 2--> x[i]+x[i-4]>=x[i-2] && x[i-1]=x[i-3]
        if (x[i] + x[i - 4] >= x[i - 2] && x[i - 1] == x[i - 3]) {
            res = true;
        }
        if (i == 4) return res;
        if (x[i] + x[i - 4] >= x[i - 2] && x[i - 1] + x[i - 5] >= x[i - 3] && x[i-1] <= x[i-3] && x[i-4] <=x[i-2] ) {
            res = true;
        }
        return res;
    }
}
