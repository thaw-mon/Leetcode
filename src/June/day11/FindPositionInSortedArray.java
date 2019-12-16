package June.day11;

/**
 * @题目 ：在排序数组中查找元素的第一个和最后一个位置
 * @题目描述： 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * @Date:19/6/23 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 */

public class FindPositionInSortedArray {

    public static void main(String[] args) {
        int[] nums = {8, 8, 8, 8};
        int target = 8;
        int[] ans = new FindPositionInSortedArray().searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int ans = searchNumber(nums, target);
        if (ans == -1) {
            res[0] = ans;
            res[1] = ans;
        } else {
            int left = ans, right = ans;
            while (left > 0 && nums[left - 1] == target) {
                left--;
            }
            while (right < nums.length - 1 && nums[right + 1] == target) {
                right++;
            }
            res[0] = left;
            res[1] = right;
        }
        return res;
    }

    private int searchNumber(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
