package September.day02;

/**
 * @题目 ： 213. House Robber II
 * @Data 19/9/03
 * @题目描述： You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * @题目地址： 链接：https://leetcode-cn.com/problems/house-robber-ii
 * @示例1: ######
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * @示例2: ###
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * @示例3: ###
 */

public class HouseRobberII {

    //和版本以不同的是，其构成了循环
    //思想：把版本一方法执行两边 分别位 1---n-1和 2 --- n
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        int n = nums.length;
        //特例 n == 1 时，两个循环都会跳过
        if(n == 1) return nums[0];
        for (int i = 0; i < n - 1; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        int prevMax2 = 0;
        int currMax2 = 0;
        for (int i = 1; i < n; i++) {
            int temp = currMax2;
            currMax2 = Math.max(prevMax2 + nums[i], currMax2);
            prevMax2 = temp;
        }
        return Math.max(currMax, currMax2);
    }
}
