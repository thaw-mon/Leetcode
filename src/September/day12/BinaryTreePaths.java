package September.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @题目 ： 257. Binary Tree Paths
 * @Data 19/9/19
 * @题目描述： Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 * @题目地址： 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * @示例1: ######
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * @示例2: ###
 * @示例3: ###
 */

public class BinaryTreePaths {

    private List<String> res = new ArrayList<>();

    //获取所有从根到叶子节点的路径
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return res;
    }

    private void helper(TreeNode root, StringBuilder sb) {

        //叶子节点
        if (root.left == null && root.right == null) {
            res.add(new String(sb.toString() + root.val));
        }
        int sLen = sb.length();
        sb.append(root.val).append("->");
        //遍历左子树
        if (root.left != null) helper(root.left, sb);

        //遍历右子树
        if (root.right != null) helper(root.right, sb);

        sb.delete(sLen, sb.length());
    }
}
