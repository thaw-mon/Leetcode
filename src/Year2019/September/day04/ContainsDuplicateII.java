package Year2019.September.day04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @题目 ： 217. Contains Duplicate II
 * @Data 19/9/05
 * @题目描述： Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * @题目地址： 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * @示例1: ######
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * @示例2: ###
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * @示例3: ###
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */

public class ContainsDuplicateII {
    //判断重复元素的距离 使用hashMap key = num value = index
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //存在重复元素,且j-i <= k
            if (i - numMap.getOrDefault(nums[i], -k-1) <= k)
                return true;
            //更新nums[i]
            numMap.put(nums[i], i);
        }
        return false;
    }

    //使用HashSet更快一点
//     作者：LeetCode
//    链接：https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


}
