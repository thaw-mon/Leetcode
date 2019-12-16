package June.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：46. 全排列
 * @题目描述： 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * @Date:19/6/26
 * @示例 1: 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 */

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Permutations().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        getPermute(nums,0,ans);
        return res;
    }

    private void getPermute(int[] list, int k, List<Integer> ans) {
        if (list.length == ans.size()) {
            res.add(ans);
            return;
        }

        int n = list.length;
        for (int i = k; i < n; i++) {
            List<Integer> tmp = new ArrayList<>(ans);
            // 从固定的数后第一个依次交换
            tmp.add(list[i]);
            swap(list, k, i);
            getPermute(list, k + 1, tmp);
            // 这组递归完成之后需要交换回来
            swap(list, k, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
