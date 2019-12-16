package December.day03;

/**
 * @题目 ：410. Split Array Largest Sum
 * @Data 19/12/05
 * @题目描述： Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * @题目链接： 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * @示例1: ######
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * Output:
 * 18
 * <p>
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * @示例2: ######
 * @示例3: ###
 */

public class SplitArrayLargestSum {
    //分成m个子数组，使得子数组中最大的值最小
    //1.暴力法：DFS(超时)
    //2.动态规划思路
    public int splitArray(int[] nums, int m) {
        int[] subs = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            subs[i + 1] = subs[i] + nums[i];
        }
        // f[i][j] 定义为将 nums[0..i] 分成 j 份时能得到的最小的分割子数组最大值。
        int[][] dp = new int[nums.length + 1][m + 1];
        dp[0][0] = 0;
        for(int i=1;i<=nums.length;i++) dp[i][0] = Integer.MAX_VALUE;
        for (int j = 1; j <= m; j++) dp[0][j] = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    //dp[i][j] = Math.max(dp[k][j-1] ,subs[i] - subs[k])
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], subs[i] - subs[k]));
                }
            }
        }

        return dp[nums.length][m];
    }


    //3.二分搜索法
    //作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/split-array-largest-sum/solution/fen-ge-shu-zu-de-zui-da-zhi-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int splitArray2(int[] nums, int m) {
        long l = 0;
        long r = 0;
        int n = nums.length;
        //l是最大值，r = sum  res在区间[l,r)
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }
        long ans = r;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= m) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }


}
