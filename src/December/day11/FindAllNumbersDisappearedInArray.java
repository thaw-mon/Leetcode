package December.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：448. Find All Numbers Disappeared in an Array
 * @Data 19/12/23
 * @题目描述： Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * @题目链接： 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * @示例1: ######
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 * @示例2: ######
 * @示例3: ###
 */

public class FindAllNumbersDisappearedInArray {

    //这道题好像重复了，之前有一道一模一样的，不过是计算出现两次的数字，而这里求的是未出现的数字
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //给数组原地设置标志位（出现的设为负值）
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);
            //出现过的数字在对于位上设置位负数
            if (nums[temp - 1] > 0)
                nums[temp - 1] *= -1;
        }
        for(int i=0;i < nums.length; i++){
            if(nums[i] > 0)
                res.add(i+1);
        }
        return res;
    }
    //类似的 ： 还有一种思路使用鸽巢原理解答
    public void swap(int[] nums, int index1, int index2){
        if (index1 != index2){
            nums[index1] = nums[index1] ^ nums[index2];
            nums[index2] = nums[index1] ^ nums[index2];
            nums[index1] = nums[index1] ^ nums[index2];
        }
    }
//      作者：jerry4free
//    链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/geng-zhi-jue-geng-ben-zhi-by-jerry4free/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int l = nums.length;
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < l; i++){
            while (nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i = 0; i < l; i++){
            if (nums[i] != i+1){    // 如果鸽子不在正确的巢里
                ret.add(i+1);       // 这个巢本该有的鸽子就是缺失的数字
            }
        }
        return ret;
    }


}
