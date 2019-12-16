package July.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：113. 路径总和 II
 * @题目描述： 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * @示例 2: ###
 **/

public class PathSumII {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> ans) {
        if (root == null)
            return;

        sum -= root.val;
        ans.add(root.val);
        if ((root.left == null) && (root.right == null)) {
            if (sum == 0)
                res.add(new ArrayList<>(ans));
            ans.remove(ans.size()-1);
            return;
        }
        helper(root.left, sum, ans);
        helper(root.right, sum, ans);
        ans.remove(ans.size()-1);
    }
}
