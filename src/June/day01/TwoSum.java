package June.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Data 19/5/29
 * @题目描述： 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @示例： 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 15};

        int[] res = twoSum(nums, 9);
        System.out.println(res[0] + " , " + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        //暴力搜索法 O(n^2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    //两遍hash法
    //时间复杂度O(n) 空间复杂度O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int leftResult = target - nums[i];
            if (hashMap.containsKey(leftResult) && hashMap.get(leftResult) != i)
                return new int[]{i, hashMap.get(leftResult)};
        }
       throw new IllegalArgumentException("No two sum solution");
    }

    //一遍hash法
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[] { hashMap.get(complement), i };
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
