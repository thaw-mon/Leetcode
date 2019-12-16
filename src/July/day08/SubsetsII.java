package July.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @题目 ：90. 子集 II
 * @题目描述： 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @Date: 19/7/10
 * @示例 1: 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * @示例 2: ####
 **/
public class SubsetsII {
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 2,2,2};
        new SubsetsII().subsetsWithDup(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先对数组排序
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        getSubsets(nums, 0, new ArrayList<>());
        return res;
    }

    private void getSubsets(int[] nums, int k, List<Integer> list) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>(list);
        for (int i = k; i < n; i++) {
            if (i > k && nums[i] == nums[i - 1])
                continue;
            ans.add(nums[i]);
            res.add(new ArrayList<>(ans));
            getSubsets(nums, i + 1, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
