package October.day10;

import java.util.*;

/**
 * @题目 ： 329. Longest Increasing Path in a Matrix
 * @Data 19/10/19
 * @题目描述： Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array.
 * Return the minimum number of patches required.
 * @题目链接： 链接：https://leetcode-cn.com/problems/patching-array
 * @示例1: ######
 * Input: nums = [1,3], n = 6
 * Output: 1
 * Explanation:
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * @示例2: ######
 * Input: nums = [1,5,10], n = 20
 * Output: 2
 * Explanation: The two patches can be [2, 4].
 * @示例3: ###
 * Input: nums = [1,2,2], n = 5
 * Output: 0
 */

public class PatchingArray {
    public static void main(String[] args) {
        int[] nums = {1,2,31,33};
        int n = 2147483647;
        System.out.println(new PatchingArray().minPatches3(nums, n));
    }

    public int minPatches(int[] nums, int n) {
        //当n值过大时，会导致内存太大无法运行
        int[] dp = new int[n + 1];
        int len = nums.length;
        int index = 0;
        int add = 0;
        for (int i = 1; i <= n; i++) {
            //每次选择一个数字填充
            if (dp[i] == 0) {
                int j = 0;
                //无法使用index进行填充,需要添加数字i
                if (index >= len || nums[index] > i) {
                    add++;
                    while (j < i) {
                        if (j + i > n)
                            break;
                        dp[j + i] = 1;
                        j++;
                    }
                } else {
                    //使用index进行填充
                    while (j < i) {
                        if (j + nums[index] > n)
                            break;
                        dp[j + nums[index]] = 1;
                        j++;
                    }
                    index++;
                }


            }
        }
        return add;
    }

    //dp数组改为set还是会导致同样的问题-->我们发现每一次数字添加的都是一段连续的数组，因此可以优化
    public int minPatches2(int[] nums, int n) {
        int len = nums.length;
        int index = 0;
        int add = 0;
        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            //每次选择一个数字填充
            if (!set.contains(i)) {
                int j = 0;
                //无法使用index进行填充,需要添加数字i
                if (index >= len || nums[index] > i) {
                    add++;
                    while (j < i) {
                        if (j + i > n)
                            break;
                        set.add(i + j);
                        j++;
                    }
                } else {
                    //使用index进行填充
                    while (j < i) {
                        if (j + nums[index] > n)
                            break;
                        set.add(j + nums[index]);
                        j++;
                    }
                    index++;
                }


            } else {
                set.remove(i);
            }
        }
        return add;
    }

    //最后发现由于每一次都是连续的片段,因此不需要dp数组，也不需要循环赋值
    //只要确定添加当前值后的上界就行了
    public int minPatches3(int[] nums, int n) {
        int len = nums.length;
        int index = 0;
        int add = 0;
        for (long i = 1; i <= n; i++) {
            //说明缺失数字i
            if (index >= len || nums[index] > i) {
                //add Num i
                //i+0 -- i+i-1
                add++;
                i = 2 * i - 1;
            } else {
                //1 <= nums[index] <= i;
                // nums[index] +0 -- nums[index]+i-1
                i = nums[index++] + i - 1;
            }
        }
        return add;
    }

}
