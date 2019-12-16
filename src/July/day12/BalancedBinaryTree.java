package July.day12;

/**
 * @题目 ：110. 平衡二叉树
 * @题目描述： 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @示例 1：
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * @示例 2: 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 **/

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        int ans = helper(root, 0);
        return ans != -1;
    }

    private int helper(TreeNode root, int level) {
        if (root == null || level == -1)
            return level;
        int left = helper(root.left, level + 1);
        int right = helper(root.right, level + 1);
        if (Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right);
    }
}
