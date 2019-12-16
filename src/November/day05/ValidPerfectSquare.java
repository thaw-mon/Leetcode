package November.day05;

/**
 * @题目 ： 367. Valid Perfect Square
 * @Data 19/11/14
 * @题目描述： Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * @题目链接： 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * @示例1: ######
 * Input: 16
 * Output: true
 * @示例2: ######
 * Input: 14
 * Output: false
 * @示例3: ###
 */

public class ValidPerfectSquare {
    public static void main(String[] args){
        System.out.println(new ValidPerfectSquare().isPerfectSquare(808201));
    }
    //判断是否为有效平方数
    //注意特殊值1
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int right = num / 2;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(Integer.MAX_VALUE / mid < mid){
                right = mid-1;
                continue;
            }
            long power = mid * mid; //可能会产生溢出问题，要使用long(还是溢出了)
            if (power == num) return true;
            else if (power > num) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return false;
    }
}
