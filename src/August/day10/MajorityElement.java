package August.day10;

/**
 * @题目 ：169. Majority Element
 * @Data: 19/8/16
 * @题目描述： Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @题目地址： 链接：https://leetcode-cn.com/problems/majority-element
 * @示例1: ######
 * Input: [3,2,3]
 * Output: 3
 * @示例2: ###
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * @示例3: ###
 **/

public class MajorityElement {

    //经典算法中的Boyer-Moore投票问题-->每次去掉两个不同的数字，最后剩下的必然是major
    //之前由于使用了continue，导致很慢
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer major = null;
        for (int num : nums) {
            if (count == 0) {
                major = num;
            }
            //优化写法
            count += major == num ? 1 : -1;
        }
        return major;
    }
}
