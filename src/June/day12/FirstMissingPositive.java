package June.day12;

/**
 * @题目 ：41. 缺失的第一个正数
 * @题目描述： 给给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * @Date:19/6/24
 * @说明:
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * @示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * @示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 */


public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 基本情况
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        // nums = [1]
        if (n == 1)
            return 2;

        // 用 1 替换负数，0，
        // 和大于 n 的数
        // 在转换以后，nums 只会包含
        // 正数
        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        // 使用索引和数字符号作为检查器
        // 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
        // 如果 nums[2] 是正数 表示数字 2 没有出现
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // 如果发现了一个数字 a - 改变第 a 个元素的符号
            // 注意重复元素只需操作一次
            if (a == n)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        // 现在第一个正数的下标
        // 就是第一个缺失的数
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }


    //way2 ;桶排序思想
//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/two-sum/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // 关键字：桶排序，什么数字就要放在对应的索引上，其它空着就空着
    // 最好的例子：[3,4,-1,1]
    // 整理好应该是这样：[1,-1,3,4]，
    // 这里 1，3，4 都在正确的位置上，
    // -1 不在正确的位置上，索引是 1 ，所以返回 2

    // [4,3,2,1] 要变成 [1,2,3,4]，*** Offer 上有类似的问题。

    // 这里负数和大于数组长度的数都是"捣乱项"。

    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 前两个是在判断是否成为索引
            // 后一个是在判断，例如 3 在不在索引 2 上
            // 即 nums[i] ?= nums[nums[i]-1] 这里要特别小心
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 第 3 个条件不成立的索引的部分是 i 和 nums[i]-1
                swap(nums, nums[i] - 1, i);
            }
        }

        // 调试代码
        // System.out.println(Arrays.toString(nums));

        for (int i = 0; i < len; i++) {
            // [1,-2,3,4]
            // 除了 -2 其它都满足： i+1 = num[i]
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
