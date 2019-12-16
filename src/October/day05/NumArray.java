package October.day05;

/**
 * @题目 ： 307. Range Sum Query - Mutable
 * @Data 19/10/11
 * @题目描述： Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * @题目地址： 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * @示例1: ######
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * @示例2: ######
 * @示例3: ###
 */

public class NumArray {

    private int[] array;

    public NumArray(int[] nums) {
        int n = nums.length;
        array = new int[n + 1];
        for (int i = 0; i < n; i++) {
            array[i+1] = array[i] + nums[i];
        }
    }

    public void update(int i, int val) {
        int preVal = array[i+1] - array[i];
        for(int j = i+1;j<array.length;j++){
            array[j] += val - preVal;
        }
    }

    public int sumRange(int i, int j) {
        return array[j+1] - array[i];
    }

    //TODO 优化策略：线段树写法

}
