package June.day10;

/**
 * @题目描述： 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * @Date: 19/6/16
 *@示例 1:
 * 输入-->输出：
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 输出：[0,9]
 * 思路：首先从右往左找到降序排列--这个降序排列不会有更大的了，于是需要引入一个值使得它的排列更大
 * 引入值需要和降序排列比较选择最近的比他大的值。然后把降序排列变成升序排列
 *
 */

public class NextPermutation {

    //    作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/two-sum/solution/xia-yi-ge-pai-lie-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        //降序排列改为升序排列
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
