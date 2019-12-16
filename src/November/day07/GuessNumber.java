package November.day07;

/**
 * @题目 ： 374. Guess Number Higher or Lower
 * @Data 19/11/18
 * @题目描述： We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * @题目链接： 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * @示例1: ######
 * Input: n = 10, pick = 6
 * Output: 6
 * @示例2: ######
 * @示例3: ###
 */

public class GuessNumber {

    public int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = guess(mid);
            switch (val) {
                case 0:
                    return mid;
                case 1:
                    //小了
                    left = mid + 1;
                    break;
                case -1:
                    //猜大了
                    right = mid - 1;
                    break;
                default:

            }
        }
        return left;
    }
}
