package September.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @题目 ： 260. Single Number III
 * @Data 19/9/19
 * @题目描述： Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * Note:
 * <p>
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * <p>
 * @题目地址： 链接：https://leetcode-cn.com/problems/single-number-iii
 * @示例1: ######
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * @示例2: ###
 * @示例3: ###
 */

public class SingleNumberIII {
    //找到只出现一次的两个数字
    //通过了,但是没有符合常量级空间的要求
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else
                set.add(num);
        }
        //由于int[]类型不能直接准换,所以需要遍历set
        int[] res = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int i=0;
        while (it.hasNext()){
            res[i++] = it.next();
        }
        return res;
    }

    //位运算解决思路
//    作者：spirit-9
//    链接：https://leetcode-cn.com/problems/single-number-iii/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-9/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //Mask地方最难想 xor = a ^ b --> a = 7= 0111(2) b = 9 = (1001)2
    // a 独有 0110 b 独有 1000
    // xor = 1110(2) mask =xor & -xor = 0010(2) 这里你会发现 mask只有一个1，且其为a,b独有1部分的最低位1
    //对于任何数字 c & mask 只有两种结果 mask or 0 a和b必然会分到不同组中去
    public int[] singleNumber2(int[] nums) {
        int xor = 0;
        for (int i : nums)// 一样的抵消,不一样的两个数字异或运算结果必定有一位是1
            xor ^= i;

        int mask = xor & (-xor);

        int[] ans = new int[2];
        for (int i : nums) {
            if ((i & mask) == 0)//== 0、 == mask 两种结果
                ans[0] ^= i;
            else
                ans[1] ^= i;
        }

        return ans;
    }


}
