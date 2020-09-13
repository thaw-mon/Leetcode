package Year2019.September.day13;

import java.util.Arrays;

/**
 * @题目 ： 268. Missing Number
 * @Data 19/9/20
 * @题目描述： Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * @题目地址： 链接：https://leetcode-cn.com/problems/missing-number
 * @示例1: ######
 * Input: [3,0,1]
 * Output: 2
 * @示例2: ###
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * @示例3: ###
 */

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {6, 4, 2, 3, 5, 7, 1};
        System.out.println(new MissingNumber().missingNumber2(nums));
    }

    //找到缺失的数字
    //简单思路1 : 排序 + 遍历  Time : O(nlogn)
    //注意 nums = [0,1,2,3]的情形
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (i != nums[i])
                return i;
        return nums.length;
    }

    //要达到线性时间复杂度和常量级的空间
    //思路2 :快排思路,不需要完全排好序
    //存在问题,当数字缺失的是最后一个时,又退化为排序算法了
    public int missingNumber2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            int index = split(nums, left, right);
            //左边是不缺数字的
            if (tmp == index) {
                left = index + 1;
            } else {
                right = index;
            }
        }
        return nums[left] == left ? left + 1 : left;
    }

    //快排算法中的spilt
    private int split(int[] nums, int left, int right) {
        int n = nums.length;
        int mid = nums[left];
        while (left < right) {
            while (left < right && nums[right] > mid)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= mid)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = mid;
        return left;
    }

    //位运算思路 : 666  基本思想 A^A =0 A^0=A
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    //数学方法求和 :  略
    // sum(0-n) = (0+n)*n/2; MissingNum = sum(0,n)-nums[]



}
