package November.day10;

/**
 * @题目 ： 390. Elimination Game
 * @Data 19/11/29
 * @题目描述： GThere is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 *
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 *
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 *
 * Find the last number that remains starting with a list of length n.
 *
 *
 * @题目链接： 链接：https://leetcode-cn.com/problems/elimination-game
 * @示例1: ######
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 *
 * Output:
 * 6
 *
 * @示例2: ######
 * @示例3: ###
 */


public class EliminationGame {
    //暴力法会超时，要找规律
    //大佬解答链接 ：https://blog.csdn.net/afei__/article/details/83689502
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
