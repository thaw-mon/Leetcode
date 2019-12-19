package December.day09;

import java.util.Random;

/**
 * @题目 ：441. Arranging Coins
 * @Data 19/12/19
 * @题目描述： You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * @题目链接： 链接：https://leetcode-cn.com/problems/arranging-coins
 * @示例1: ######
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * @示例2: ######
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 * @示例3: ###
 */

public class ArrangingCoins {

    public static void main(String[] args){
        ArrangingCoins demo = new ArrangingCoins();
        Random random = new Random();//随机数种子为系统时间
        for(int i=0;i<100;i++){
            int r = random.nextInt();
            assert (demo.arrangeCoins(r)==demo.arrangeCoins2(r));
        }
    }
    //简单的暴力法
    public int arrangeCoins(int n) {
        int step = 1;
        while (n >= step) {
            n -= step;
            step++;
        }
        return step-1;
    }

    //优化策略：我们大小前n行的和为（1+n)*n / 2
    public int arrangeCoins2(int n) {
        //设置初始step = sqrt(2n)
        int step = (int)Math.sqrt(2 * n);
        n -= (1 + step) * step / 2;
        if(n > 0)
            step++;
        while (n >= step) {
            n -= step;
            step++;
        }
        return step-1;
    }

    //更加优化的数学公式法
//        作者：homesway
//    链接：https://leetcode-cn.com/problems/arranging-coins/solution/zhi-jie-qiu-kk1-2-nde-jie-ran-hou-qu-zheng-ji-ke-y/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int arrangeCoins3(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }


}
