package November.day03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @题目 ： 349. Intersection of Two Arrays
 * @Data 19/11/10
 * @题目描述： Given two arrays, write a function to compute their intersection.
 * @题目链接： 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @示例1: ######
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * @示例2: ######
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * @示例3: ###
 */

public class IntersectionTwoArrays {
    //找两个数组的交集
    //也可以使用set的内置方法 ： retainAll
    public int[] intersection(int[] nums1, int[] nums2) {
        //1.把一个数组转换为set
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        Set<Integer> intersection = new HashSet<>();
        for(int num : nums2){
            if(set.contains(num))
                intersection.add(num);
        }
        int[] res = new int[intersection.size()];
        Iterator<Integer> iter = intersection.iterator();
        int i = 0;
        while (iter.hasNext()){
            res[i++] = iter.next();
        }
        return res;
    }
}
