package Year2019.October.day11;

/**
 * @题目 ： 334. Increasing Triplet Subsequence
 * @Data 19/10/24
 * @题目描述： Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * @题目链接： 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 * @示例1: ######
 * Input: [1,2,3,4,5]
 * Output: true
 * @示例2: ######
 * Input: [5,4,3,2,1]
 * Output: false
 * @示例3: ###
 */

public class IncreasingTripletSubsequence {
    //记录最小值和第二大的数字  -->可以获得正确解但是不能获得对应的三元组
    //eg 5 6 1 7
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        //记录最小值和最大值
        int min = Integer.MAX_VALUE;
        int secMax = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= secMax) {
                secMax = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    //通解思路:
//    维护一个子序列数组win，该数组长度最长为3。初始化win为[nums[0]]，随后遍历数组。
    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) return false;
        int[] win = new int[3];
        win[0] = nums[0];
        int p = 0, q = 0;
        for (int num : nums) {
            if (num > win[q]) {
                win[++q] = num;
                if (q >= 2) return true;
            } else {
                int i = q;
                while (i > 0 && win[i - 1] >= num)
                    i--;
                win[i] = num;
            }
        }
        return false;
    }

}
