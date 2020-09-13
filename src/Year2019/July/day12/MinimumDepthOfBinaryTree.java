package Year2019.July.day12;

/**
 * @题目 ：110. 平衡二叉树
 * @题目描述： 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * @示例 1：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * @示例 2: ###
 **/
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return helper(root, 0);
    }

    //这道题实际上是求平衡二叉树变种
    //注意[1,2]这个输入，会产生错误结果1 正确结果应该是2
    private int helper(TreeNode root, int level) {
        if (root == null)
            return level;
        if (root.left == null)
            return helper(root.right, level + 1);
        if (root.right == null)
            return helper(root.left, level + 1);

        int left = helper(root.left, level + 1);
        int right = helper(root.right, level + 1);

        return Math.min(left, right);
    }
}
