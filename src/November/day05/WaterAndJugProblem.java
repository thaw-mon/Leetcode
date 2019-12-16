package November.day05;

import java.util.*;

/**
 * @题目 ： 365. Water and Jug Problem
 * @Data 19/11/14
 * @题目描述： You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * <p>
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * @题目链接： 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * @示例1: ######
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * @示例2: ######
 * Input: x = 2, y = 6, z = 5
 * Output: False
 * @示例3: ###
 */

public class WaterAndJugProblem {

    public static void main(String[] args) {
        System.out.println(new WaterAndJugProblem().canMeasureWater(11, 3, 13));
    }

    //通过x,y水壶得到z升水-->x,y水壶可以倒出多大类型的水(k种可能性)，通过k种水生成z升水
    // (假设 x > y ) x 、 y 、 x -ky (>0)
    //居然有 0 0 1的输入
//      作者：feng-hui-ting-xi-2
//        链接：https://leetcode-cn.com/problems/water-and-jug-problem/solution/javati-jie-huo-de-suo-you-zhuang-tai-by-feng-hui-t/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean canMeasureWater(int x, int y, int z) {
        if (x+y==z || z==0)
            return true;
        if (x+y<z)
            return false;
        if (x==y)
            return x==z;
        //保证y>x
        if (x>y){
            int c = x;
            x = y;
            y = c;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int hel = y;
        while (!map.containsKey(hel)){
            map.put(hel, 1);
            if (hel<x)
                hel += y;
            else
                hel -= x;
            if (hel == z)
                return true;
        }
        return false;
    }


//     作者：zuo-zhou-ren
//        链接：https://leetcode-cn.com/problems/water-and-jug-problem/solution/zui-da-gong-yue-shu-qiu-fa-jie-jian-si-lu-by-zuo-z/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //神奇的gcd解法
    public boolean canMeasureWater2(int x, int y, int z) {
        if(x == 0 && y == 0) return z == 0;
        return z == 0 || (z % gcd(x,y) == 0 && x + y >= z);
    }
    static int gcd(int x,int y){
        if(y == 0) return x;
        int r = x % y;
        return gcd(y,r);
    }
}
