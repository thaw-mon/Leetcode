package Year2020.January.day02;

import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：464. Can I Win
 * @Data 20/01/07
 * @题目描述：In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.
 * <p>
 * What if we change the game so that players cannot re-use integers?
 * <p>
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
 * <p>
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
 * <p>
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 * @题目链接： 链接：https://leetcode-cn.com/problems/can-i-win
 * @示例1: ######
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 * <p>
 * Output:
 * false
 * @示例2: ######
 * @示例3: ###
 */

public class CanIWin {

    //判断先手是否可以稳赢（累计和>= desiredTotal）注意不能使用重复数字
    //规律 ： 当total = 最大最小值和时，先手必输
    //保留最大最小值进行判断，如果一轮不能结束，该如何选择
    //1. total <= max 必赢

    //参考大佬的解法，使用map记录搜索结果
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        //先考虑穷举法吧
        //1. total <= max 必赢
        if (desiredTotal <= maxChoosableInteger) return true;
        //2. total > sum(choose) 必输
        if (desiredTotal > (maxChoosableInteger + 1) * maxChoosableInteger / 2) return false;

        //3.其他场景递归判断
        Map<Integer, Boolean> myMap = new HashMap<>();


        return canWin(maxChoosableInteger,desiredTotal,0,myMap);
    }

    private boolean canWin(int length, int nowTarget, int used, Map<Integer, Boolean> myMap) {

        if (myMap.containsKey(used))
            return myMap.get(used);
        //穷举法
        for (int i = 1; i <= length; i++) {
            int k = 1 << (i - 1);
            if ((used & k) == 0) {    //代表数字i没有使用
                //这轮直接胜利 或者 这轮选择后对方必输
                if (nowTarget <= i || !canWin(length, nowTarget - i, used | k, myMap)) {
                    myMap.put(used, true);
                    return true;
                }
            }
        }
        myMap.put(used, false);
        return false;
    }

}
