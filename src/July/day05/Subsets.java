package July.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：78. 子集
 * @题目描述： 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @Date:19/7/5
 * @示例 1: 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 **/

public class Subsets {
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args){
        int[] nums = {1,2,3};
        new Subsets().subsets(nums);
        for(List<Integer> ans : res){
            System.out.println(ans);
        }
        System.out.println(2<<3);
        binaryBit(nums);
    }
    //nums的子集 2^n个
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        res.add(ans);
        getSubSets(nums,ans,0);
        return res;
    }

    private void getSubSets(int[] nums, List<Integer> ans,int k) {

        for (int j = k; j < nums.length; j++) {
            ans.add(nums[j]);
            res.add(new ArrayList<>(ans));
            getSubSets(nums,ans,j+1);
            ans.remove(ans.size()-1);
        }
    }

//       作者：dao-fa-zi-ran-2
//    链接：https://leetcode-cn.com/problems/two-sum/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //循环枚举思路
    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

//    作者：dao-fa-zi-ran-2
//    链接：https://leetcode-cn.com/problems/two-sum/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //二进制位思路
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }



}
