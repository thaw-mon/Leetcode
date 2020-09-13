package Year2019.August.day16;

/**
 * @题目 ：209. Minimum Size Subarray Sum
 * @Data 19/8/31
 * @题目描述： Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * @题目地址： 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * @示例1: ######
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * @示例2: ###
 * @示例3: ###
 */

public class MinimumSizeSubarraySum {


    //暴力法 O(N*2)
    public int minSubArrayLen(int s, int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        //num[i]表示前i个数字之和
        for (int i = 0; i < n; i++) {
            if (i == 0) continue;
            nums[i] += nums[i - 1];
        }
        if (nums[n - 1] < s)
            return 0;
        int res = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < s) continue;
            int j = 0;
            for (; j <= i; j++) {
                if (nums[i] - nums[j] < s) break;
            }
            // num[i] - num[j] < s;
            res = Math.min(res, i - j + 1);
            if (res == 1) break;
        }
        return res;
    }

    //使用两个指针   滑动窗口
//      作者：LeetCode
//    链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int minSubArrayLen2(int s, int[] nums)
    {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }


}
