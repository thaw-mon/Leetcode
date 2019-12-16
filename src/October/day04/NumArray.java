package October.day04;

/**
 * @题目 ： 303. Range Sum Query - Immutable
 * @Data 19/10/09
 * @题目描述： Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * @题目地址： 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * @示例1: ######
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * @示例2: ######
 * @示例3: ###
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
public class NumArray {

    private int[] array;

    public NumArray(int[] nums) {
        int n = nums.length;
        array = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                array[i] = nums[i];
                continue;
            }
            array[i] = array[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return array[j];
        else
            return array[j] - array[i - 1];
    }
}
