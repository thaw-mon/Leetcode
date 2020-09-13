package Year2020.April.day05;

public class Demo01 {


    /**
     * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     */
    class NumArray {

        int[] dp;
        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                dp[i + 1] = dp[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return dp[j + 1] - dp[i];
        }
    }
}
