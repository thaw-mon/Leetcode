package July.day11;

/**
 * @题目 ：104. 二叉树的最大深度
 * @题目描述： 给给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * @示例 1: 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3
 * @示例 2: ###
 **/

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {

        return dfs(root, 0);
    }

    //深度优先遍历+递归
    private int dfs(TreeNode root, int level) {
        if (root == null)
            return level;
        int left = dfs(root.left, level + 1);
        int right = dfs(root.right, level + 1);
        return Math.max(left, right);
    }
}
