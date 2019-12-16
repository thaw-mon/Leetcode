package August.day07;

/**
 * @题目 ：153. 寻找旋转排序数组中的最小值
 * @Data: 19/8/13
 * @题目描述： 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * @题目地址： https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @示例1: ######
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * @示例2: ###
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * @示例3: ###
 **/

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args){
        int[] nums = {4,1,2};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin2(nums));
    }

    //这道题似乎在前面出现过
    //懒人写法，遍历一遍 时间O(N)
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, nums[i]);
        }
        return res;
    }

    //优化写法 O(log N)
    public int findMin2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int left = 0, right = n - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            // mid 在前半段
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                //mid在后半段

                //left 在左半段
                if (nums[left] > nums[right]) {
                    left++;
                }
                right = mid;
            }
        }
        return nums[left];
    }

}
