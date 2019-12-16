package August.day10;

/**
 * @题目 ：167. Two Sum II - Input array is sorted
 * @Data: 19/8/16
 * @题目描述： Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * @Note: ####
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * @题目地址： 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * @示例1: ######
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * @示例2: ###
 * @示例3: ###
 **/

public class TwoSumII {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] ans  = new TwoSumII().twoSum(nums, target);
        for(int i : ans)
            System.out.println(i);
    }

    //双指针法-->需要思考的 当 l + r > target r-- 为什么不存在 l-k + r == target
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right){
            if(numbers[left] + numbers[right] < target)
                left++;
            else if(numbers[left] + numbers[right] > target)
                right--;
            else
                return new int[]{left+1,right+1};
        }
        return new int[0];
    }
}
