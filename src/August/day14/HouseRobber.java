package August.day14;

/**
 * @题目 ：198. House Robber
 * @Data 19/8/29
 * @题目描述： You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * @题目地址： 链接：https://leetcode-cn.com/problems/house-robber
 * @示例1: ######
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * @示例2: ###
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * @示例3: ###
 */

public class HouseRobber {
    public static void main(String[] args){
        int[] nums = {2,7,9,3,1};
        System.out.println(new HouseRobber().rob(nums));
    }

    //dp问题
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            int max = 0;
            for (int num : nums)
                max = Math.max(max, num);
            return max;
        }
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < n; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }

//        作者：LeetCode
//    链接：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //动态规划优化写法 ：只需要两个变量
    public int rob2(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }


}
