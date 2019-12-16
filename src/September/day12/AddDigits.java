package September.day12;

/**
 * @题目 ： 258. Add Digits
 * @Data 19/9/19
 * @题目描述： Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * @题目地址： 链接：https://leetcode-cn.com/problems/add-digits
 * @示例1: ######
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * @示例2: ###
 * @示例3: ###
 */

public class AddDigits {
    public int addDigits(int num) {
        int res = num;
        while (num >= 10){
            res = 0;
            //一轮循环
            while (num > 0) {
                res += num % 10;
                num /= 10;
            }
            num = res;
        }
        return res;
    }
}
