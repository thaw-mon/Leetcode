package September.day15;

/**
 * @题目 ： 287. Find the Duplicate Number
 * @Data 19/9/28
 * @题目描述： Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * @题目地址： 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * @示例1: ######
 * Input: [1,3,4,2,2]
 * Output: 2
 * @示例2: ###
 * Input: [3,1,3,4,2]
 * Output: 3
 * @示例3: ###
 */

public class FindDuplicateNumber {

    //只有一个重复数字，但是可能重复不止一次
    //二分查找法
    public int findDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) {
                    count++;
                }
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }


    //鸽巢原理+快慢指针法
//    作者：LeetCode
//        链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int findDuplicate2(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);


        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
