package Year2019.August.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：144. 二叉树的前序遍历
 * @Data: 19/8/09
 * @题目描述： 给定一个二叉树，返回它的 前序 遍历
 * @题目地址： https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @示例1: ######
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * @示例2: ###
 **/

public class BinaryTreePreorderTraversal {
    //前序遍历 根左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
