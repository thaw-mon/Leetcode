package October.day10;


/**
 * @题目 ： 322. Coin Change
 * @Data 19/10/19
 * @题目描述： Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * @题目链接： https://leetcode-cn.com/problems/count-of-range-sum
 * Note:
 * A naive algorithm of O(n^2) is trivial. You MUST do better than that.
 * @示例1: ######
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2
 * @示例2: ######
 * @示例3: ###
 */

public class CountOfRangeSum {
    //1. 暴力求解-->O(N^2)
    //特殊值会出问题-->改为long
    // [-2147483647,0,-2147483647,2147483647]
    //-564
    //3864
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        //nums[i] = dp[i+1]-dp[i];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (dp[j] - dp[i] >= lower && dp[j] - dp[i] <= upper)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;
        new CountOfRangeSum().countRangeSum2(nums, lower, upper);
    }

    //2. 归并排序思路
    public int countRangeSum2(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] s = new long[n + 1];
        long[] assist = new long[n + 1];
        for (int i = 1; i <= n; i++)
            s[i] = s[i - 1] + nums[i - 1];

        return merge(s, assist, 0, n, lower, upper);
    }

    //         作者：xu-yuan-shu
//        链接：https://leetcode-cn.com/problems/count-of-range-sum/solution/327qu-jian-he-de-ge-shu-ti-jie-zong-he-by-xu-yuan-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int merge(long[] S, long[] assist, int L, int R, int low, int up) {
        if (L >= R) return 0;

        int cnt = 0;
        int M = L + (R - L) / 2;
        cnt += merge(S, assist, L, M, low, up);
        cnt += merge(S, assist, M + 1, R, low, up);
        int Left = L;
        int Upper = M + 1, Lower = M + 1;
        while (Left <= M) {
            while (Lower <= R && S[Lower] - S[Left] < low) Lower++;
            while (Upper <= R && S[Upper] - S[Left] <= up) Upper++;

            cnt += Upper - Lower;
            Left++;
        }
        //以下为归并排序中归并过程
        Left = L;
        int Right = M + 1;
        int pos = L;
        while (Left <= M || Right <= R) {
            if (Left > M) assist[pos] = S[Right++];
            if (Right > R && Left <= M) assist[pos] = S[Left++];

            if (Left <= M && Right <= R) {
                if (S[Left] <= S[Right]) assist[pos] = S[Left++];
                else assist[pos] = S[Right++];
            }
            pos++;
        }
        for (int i = L; i <= R; i++) S[i] = assist[i];

        return cnt;

    }
}
