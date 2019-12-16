package August.day02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @题目 ：137. 只出现一次的数字
 * @Data: 19/8/06
 * @题目描述： 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * @题目地址： https://leetcode-cn.com/problems/single-number/
 * @示例1: ######
 * 输入: [2,2,3,2]
 * 输出: 3
 * @示例2: ###
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 **/

public class SingleNumberII {

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,2,3,4,4,4};
        new SingleNumberII().singleNumber2(nums);
    }


    //类似于前一题,采用hashMap 能用但是不符合题意
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = bucket.getOrDefault(nums[i], 0);
            bucket.put(nums[i], value + 1);
        }
        int res = 0;
        for (int key : bucket.keySet()) {
            if (bucket.get(key) == 1)
                return key;
        }
        return res;
    }

    //大佬的类三进制写法
//       作者：jyd
//    链接：https://leetcode-cn.com/problems/two-sum/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for(int num : nums){
            // two的相应的位等于1，表示该位出现2次
            twos |= ones & num;
            // one的相应的位等于1，表示该位出现1次
            ones ^= num;
            // three的相应的位等于1，表示该位出现3次
            threes = ones & twos;
            // 如果相应的位出现3次，则该位重置为0
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }



}

