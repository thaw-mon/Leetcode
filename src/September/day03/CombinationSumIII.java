package September.day03;

import August.day02.Candy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @题目 ： 216. Combination Sum III
 * @Data 19/9/04
 * @题目描述： Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers
 * @题目地址： 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * @示例1: ######
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * @示例2: ###
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * @示例3: ###
 */


public class CombinationSumIII {

    public static void main(String[] args) {
        int k = 3, n = 15;
        new CombinationSumIII().combinationSum3(k, n);
        System.out.println(res);
    }

    private static List<List<Integer>> res = new ArrayList<>();

    //暴力法 + 剪枝 比较慢
    public List<List<Integer>> combinationSum3(int k, int n) {

        int min = (1 + k) * k / 2;
        int max = (9 + 9 - k + 1) * k / 2;
        if (k <= 0 || k > 9 || n < min || n > max) return res;
        //初始化sum(ans) = min
        int[] ans = new int[k];
        helper(ans, 0, n, 0);
        return res;
    }

    private void helper(int[] ans, int level, int n, int sum) {

        if (level == ans.length) {
            //符合条件
            if (sum == n) {
                List<Integer> tmp = new ArrayList<>(Arrays.stream(ans).boxed().collect(Collectors.toList()));
                res.add(tmp);
            }
            return;
        }

        int start = level == 0 ? 1 : ans[level - 1] + 1;
        for (int i = start; i <= 9; i++) {
            ans[level] = i;
            if (sum + i > n)
                break;
            helper(ans, level + 1, n, sum + i);
        }

    }


    //    作者：guanpengchn
//    链接：https://leetcode-cn.com/problems/combination-sum-iii/solution/hua-jie-suan-fa-216-zu-he-zong-he-iii-by-guanpengc/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//    回溯写法 --> 这思路不是和我一毛一样吗，不过它的输入时list，转换更快
    public void traceBack(int k, int n, int sum, int begin, LinkedList<Integer> list) {
        if (k == 0) {
            if (n == sum)
                res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < 10; i++) {
            list.add(i);
            traceBack(k - 1, n, sum + i, i + 1, list);
            list.removeLast();
        }
    }


}
