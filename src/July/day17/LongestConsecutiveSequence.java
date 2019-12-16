package July.day17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @题目 ：128. 最长连续序列
 * @Data: 19/7/31
 * @题目描述： 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * @示例1: ######
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @示例2: ###
 **/

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int num : nums) {
            bucket.put(num, num + 1);
        }
        System.out.println(bucket);
    }

    //使用hash桶策略-->将数值存入hash桶，并记录包含该值的最大长度 <value,len>
    //同时要更新端点长度
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> bucket = new HashMap<>();
        int left, right, len, res = 0;
        for (int num : nums) {
            if (bucket.containsKey(num)) continue;
            left = bucket.getOrDefault(num - 1, 0);
            right = bucket.getOrDefault(num + 1, 0);
            len = left + right + 1;
            bucket.put(num, len);
            //更新端点长度，因为下一个可能被使用，而除了端点外的节点不会再使用，所以不必更新
            bucket.put(num - left, len);
            bucket.put(num + right, len);
            res = Math.max(res, len);
        }

        return res;
    }

    //使用set
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zui-chang-lian-xu-xu-lie-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


}
