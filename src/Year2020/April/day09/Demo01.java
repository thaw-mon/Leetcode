package Year2020.April.day09;

public class Demo01 {


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        //2.使用二分法进行查找
        int l = 0, r = nums.length - 1;
        //if (target > nums[r]) return r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }else {
                l = mid;
                break;
            }
        }
        return l;
    }

}
