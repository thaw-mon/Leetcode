package Year2019.June.day14;

import java.util.*;

/**
 * @题目 ：47. 全排列 II
 * @题目描述： 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @Date:19/6/26
 * @示例 1: 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 */

public class PermutationsII {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 0, -1, 1, 0, 1};
        int[] nums = {2, 0, 1, 0, 1,-1,-1};
        System.out.println(new PermutationsII().permuteUnique(nums));
        System.out.println(res.size());
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
//        getPermute(nums, 0, ans);
        used = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        findPermuteUnique(nums,0,stack);
        return res;
    }

    private void getPermute(int[] list, int k, List<Integer> ans) {
        if (list.length == ans.size()) {
            if (res.contains(ans)) {
                System.out.println(ans);
            }
            res.add(ans);
            return;
        }

        int n = list.length;
        HashSet<Integer> set = new HashSet<>();
        // 从固定的数后第一个依次交换
        for (int i = k; i < n; i++) {
            List<Integer> tmp = new ArrayList<>(ans);
            //去重(这个去重有问题，因为在其子递归中，list不再是排好序的了)
//            if (i > k && list[i] == list[i - 1]) {
//                continue;
//            }
            if(set.contains(list[i])){
                continue;
            }
            set.add(list[i]);
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

    private boolean[] used;
//
//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/two-sum/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    private void findPermuteUnique(int[] nums, int depth, Stack<Integer> stack) {
        if (depth == nums.length) {
            List<Integer> ans = new ArrayList<>(stack);
            if(res.contains(ans)){
                System.out.println(ans);
            }
            res.add(ans);
//            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 修改 2：因为排序以后重复的数一定不会出现在开始，故 i > 0
                // 和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支
                // 这种情况跳过即可
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(nums[i]);
                findPermuteUnique(nums, depth + 1, stack);
                stack.pop();
                used[i] = false;
            }
        }
    }

}
