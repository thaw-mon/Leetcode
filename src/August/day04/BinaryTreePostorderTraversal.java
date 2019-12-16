package August.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * @题目 ：145. 二叉树的后序遍历
 * @Data: 19/8/09
 * @题目描述： 给定一个二叉树，返回它的 后序 遍历。
 * @题目地址： https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @示例1: ######
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * @示例2: ###
 **/

public class BinaryTreePostorderTraversal {
    //后序遍历 左右根
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}
