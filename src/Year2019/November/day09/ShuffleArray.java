package Year2019.November.day09;

import java.util.Random;

/**
 * @题目 ： 384. Shuffle an Array
 * @Data 19/11/25
 * @题目描述： Shuffle a set of numbers without duplicates.
 * @题目链接： 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * @示例1: ######
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * @示例2: ######
 * @示例3: ###
 */

public class ShuffleArray {

    private int[] data;
    private Random random = new Random();
    public ShuffleArray(int[] nums) {
        data = nums;

    }


    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return data;
    }

    /**
     * Returns a random shuffling of the array.
     */
    //经典的洗牌算法，思路是在前n-1张牌洗好的情况下，第n张牌随机与前n-1张牌的其中一张牌交换，或者不换.
    public int[] shuffle() {
        int[] vShuffle = new int[data.length];

        for (int i = 0; i < vShuffle.length; i++) {
            vShuffle[i] = data[i];
            int j = random.nextInt(i + 1);
            if (j != i) {
                int temp = vShuffle[i];
                vShuffle[i] = vShuffle[j];
                vShuffle[j] = temp;
            }
        }
        return vShuffle;
    }
}
