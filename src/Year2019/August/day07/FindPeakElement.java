package Year2019.August.day07;

/**
 * @题目 ：162. 寻找峰值
 * @Data: 19/8/13
 * @题目描述： 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * @题目地址： https://leetcode-cn.com/problems/find-peak-element/
 * @说明: ###
 * 你的解法应该是 O(logN) 时间复杂度的。
 * @示例1: ######
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * @示例2: ###
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * @示例3: ###
 **/

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 0;

        //比较头部和尾部
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        // 这里是废操作 nums数组必然会产生峰值
        if(n == 2) return -1;
        return helper(nums, 1, n - 2);
    }

    private int helper(int[] nums, int left, int right) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            return mid;

        int l = helper(nums, left, mid - 1);
        if (l != -1)
            return l;
        int r = helper(nums, mid + 1, right);
        if (r != -1)
            return r;

        return -1;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/xun-zhao-feng-zhi-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //思路: 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }


}
