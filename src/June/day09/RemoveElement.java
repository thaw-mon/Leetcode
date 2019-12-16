package June.day09;

/**
 * @Data 19/6/11
 * @题目描述： 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @示例1： 给定数组 nums = [1,1,2],
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * @示例2： 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        System.out.println(new RemoveElement().removeElement(nums, 2));
    }

    //easy 还是使用双指针
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = nums.length - 1;
        while (p < q) {
            while (q >= 0 && nums[q] == val) {
                q--;
            }
            if (q == -1 || p >= q) {
                return nums[p] == val ? p : p + 1;
            }
            if (nums[p] == val) {
                nums[p] = nums[q];
                nums[q] = val;
                q--;
            }
            p++;
        }

        return nums[p] == val ? p : p + 1;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/yi-chu-yuan-su-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


}
