package Year2019.October.day03;

import java.util.Arrays;

/**
 * @题目 ： 299. Bulls and Cows
 * @Data 19/10/06
 * @题目描述： Given an unsorted array of integers, find the length of longest increasing subsequence.
 * @题目地址： 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * @示例1: ######
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 *
 * <p>
 * @示例3: ###
 */

public class LongestIncreasingSubsequence {


    //动态规划写法
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
           dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    //作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //添加二分搜索的动态规划
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


}
