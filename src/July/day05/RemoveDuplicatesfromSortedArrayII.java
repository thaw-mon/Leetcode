package July.day05;

/**
 * @题目 ：80. 删除排序数组中的重复项 II
 * @题目描述： 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @Date:19/7/5
 * @示例 1: 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * @示例 2: 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 **/

public class RemoveDuplicatesfromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3};
        System.out.println(new RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int p = 0;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[p]) {
                if (!flag) {
                    flag = true;
                    p++;
                    nums[p] = nums[i];
                }
            } else {
                p++;
                flag = false;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }


    //
//    作者：luo-ben-zhu-xiao-man-tou
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zhi-jie-bian-li-yi-ci-ji-ke-by-luo-ben-zhu-xiao-ma/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //思路差不多双指针，但是写法更优雅-->隔一个比较
    public int demo(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int current = 1;           //新数组中有效位置的最后一位，新加入的数据应当写到current+1
        for (int i = 2; i < nums.length; i++) //从第三位开始循环，前两位无论如何都是要加入新数组的
        {
            if (nums[i] != nums[current - 1])  //符合条件，加入新数组
            {
                current += 1;
                nums[current] = nums[i];
            }
        }
        return current + 1;

    }
}
