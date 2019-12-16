package December.day04;

/**
 * @题目 ：414. Third Maximum Number
 * @Data 19/12/09
 * @题目描述： Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * @题目链接： 链接：https://leetcode-cn.com/problems/third-maximum-number
 * @示例1: ######
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * @示例2: ######
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * @示例3: ###
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, -2147483648};
        System.out.println(new ThirdMaximumNumber().thirdMax(nums));
    }

    //返回第三大的数字
    public int thirdMax(int[] nums) {
        int[] dp = new int[3];
        //问题来了 : [1,2,-2147483648] 会导致错误结果
        for (int i = 0; i < 3; i++) dp[i] = Integer.MIN_VALUE;  //从大到小
        int count = 2;
        for (int i = 0; i < nums.length; i++) {
            //判断nums[i]的位置
            int tmp = nums[i];
            for (int j = 2; j >= 0; j--) {
                if (j == count) {
                    dp[j] = tmp;
                    count--;
                    break;
                }
                if (tmp > dp[j]) {
                    //交换元素
                    tmp = tmp ^ dp[j];
                    dp[j] = tmp ^ dp[j];
                    tmp = tmp ^ dp[j];
                }
                if (tmp == dp[j]) {
                    break;
                }
            }
        }
        if (count >= 0) dp[0] = dp[2];
        return dp[0];
    }
}
