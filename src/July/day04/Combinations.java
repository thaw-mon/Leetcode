package July.day04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @题目 ：77. 组合
 * @题目描述： 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @Date:19/7/4
 * @示例 1: 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 **/

public class Combinations {

    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        new Combinations().combine2(n,k);
        for(List<Integer> ans : res){
            System.out.println(ans);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if(n<k){
            return res;
        }
        List<Integer> ans = new ArrayList<>();
        myCombine(ans,n,k,1);
        return res;
    }

    private void myCombine(List<Integer> ans, int n, int k, int i) {
        if (k == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j <= n; j++) {
            ans.add(j);
            myCombine(ans, n, k-1, j + 1);
            ans.remove(ans.size()-1);
        }
    }

    //字典序方法

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/two-sum/solution/zu-he-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<List<Integer>> combine2(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }

}
