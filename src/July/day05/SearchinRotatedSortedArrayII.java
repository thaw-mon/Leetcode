package July.day05;

/**
 * @题目 ：81. 搜索旋转排序数组 II
 * @题目描述： 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * @Date:19/7/5
 * @示例 1: 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * @示例 2: 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 **/

public class SearchinRotatedSortedArrayII {

    //O(N)时间复杂度,写法简单
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (target == nums[i])
                return true;
        }
        return false;
    }

    //看看大佬的O(logN)写法
//    作者：ivan_allen
//    链接：https://leetcode-cn.com/problems/two-sum/solution/81-sou-suo-xuan-zhuan-pai-xu-shu-zu-ii-er-fen-8ms-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean search2(int[] nums, int target){
        if (nums.length==0) return false;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo >> 1);
            if (nums[mid] == nums[hi]) {
                --hi; // 去重。
            } else if (target == nums[mid]
                    || (nums[mid] >= nums[lo] && nums[lo] <= target && target < nums[mid])
                    || (nums[mid] < nums[lo] && (target < nums[mid] || target >= nums[lo]))) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo] == target;

    }

}
