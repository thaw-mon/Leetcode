package Year2020.April.day09;

public class Demo02 {

    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设只有一个重复的整数，找出这个重复的数。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        //找到重复出现的数字
        // O(n^2)解法
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int count = 0;
            for (int num : nums) {
                if (num == i)
                    count++;
            }
            if (count > 1) return i;
        }
        return 0;
    }

    //作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
