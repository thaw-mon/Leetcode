package June.day11;

/**
 * @题目 ：搜索旋转排序数组
 * @题目描述： 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @Date:19/6/23 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 思路：O(logN) -->二分查找 [s1....sk,sl+1,...,sn) s1--sk 升序  sk+1--sn 升序 且s1 >sn
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target =9 ;
        System.out.println(new SearchInRotatedSortedArray().search(nums,target));
    }

    //强行判读在mid左边还是右边 不好理解
    //官方解答:先找到最小值，再匹配target
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = nums[mid];
            if (tmp == target) {
                return mid;
            }
            if (tmp < target){
                if(tmp >= nums[left]){
                    left = mid + 1;
                }else {
                    if(nums[right] >=target){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }else {
                if(tmp >= nums[left]){
                    if(nums[left] <= target){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
