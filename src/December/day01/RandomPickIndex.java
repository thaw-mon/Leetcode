package December.day01;

import java.util.Random;

/**
 * @题目 ： 398. Random Pick Index
 * @Data 19/12/02
 * @题目描述： Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * @题目链接： 链接：https://leetcode-cn.com/problems/random-pick-index
 * @示例1: ######
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 * @示例2: ######
 * @示例3: ###
 */
public class RandomPickIndex {

    private int[] res;
    public RandomPickIndex(int[] nums) {
        res = nums;
    }

    public int pick(int target) {
        Random random = new Random();
        int c = 0;
        int index = 0;
        for(int i = 0;i < res.length;i++)
            if(res[i] == target){
                c++;
                if(random.nextInt() % c == 0) index = i;
            }
        return index;
    }
}
