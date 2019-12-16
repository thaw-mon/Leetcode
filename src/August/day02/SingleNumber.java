package August.day02;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：136. 只出现一次的数字
 * @Data: 19/8/06
 * @题目描述： 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @题目地址： https://leetcode-cn.com/problems/single-number/
 * @示例1: ######
 * 输入: [2,2,1]
 * 输出: 1
 * @示例2: ###
 * 输入: [4,1,2,1,2]
 * 输出: 4
 **/

public class SingleNumber {

    //最简单的思路创建一个map 空间换时间
    //不需要value的情况下，hash表最好用hashset而不是map
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (bucket.containsKey(nums[i])) {
                bucket.remove(nums[i]);
            } else {
                bucket.put(nums[i], 1);
            }
        }
        int res = 0;
        for (int key : bucket.keySet())
            res = key;
        return res;
    }

    //题目要求不能使用额外空间，且具有线性时间复杂度
    //对nums排序，再遍历一遍
    //时间上优化了，但还是很慢
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n && nums[i] != nums[i + 1]) {
                res = nums[i];
                break;
            }
        }
        if (res == Integer.MAX_VALUE)
            res = nums[n - 1];
        return res;
    }

    //最快的写法--采用异或
//    作者：powcai
//    链接：https://leetcode-cn.com/problems/two-sum/solution/yi-huo-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int singleNumber3(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) res ^= nums[i];
        return res;
    }


}

