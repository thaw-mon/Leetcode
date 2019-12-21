package December.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：442. Find All Duplicates in an Array
 * @Data 19/12/21
 * @题目描述： Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * @题目链接： 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 * @示例1: ######
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 * @示例2: ######
 * @示例3: ###
 */

public class FindAllDuplicatesInArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 2, 6}; //无论是替换2还是替换3最后异或的结果是一样的
        new FindAllDuplicatesInArray().findDuplicates(nums);
    }

    //找到数组中出现两次的数字（数字只出现1-2次，且数字范围为1 <= X <=n）
    //最简单的方法是使用map或set但是不符合不使用额外空间的要求。
    //所以想到数字的特性：异或操作 A ^ A = 0  A^B^A = B : 把全部数字异或一边然后再判断
    //不能只用异或操作 考虑一下与操作 :也不行
    //最后参考大佬们的解法：原来可以再数组中用负号标识数字是否出现过
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {  //这个位置所在的数字出现过了
                res.add(num);
            } else
                nums[num - 1] *= -1;
        }
        return res;
    }
}
