package Year2020.May.day02;

import Year2020.May.day01.Demo01;

public class Demo03 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
     * 返回移除了所有不包含 1 的子树的原二叉树。
     *
     * @param root
     * @return
     */
    //DFS思路
    public TreeNode pruneTree(TreeNode root) {
        if (!DFS(root))
            root = null;
        return root;
    }

    private boolean DFS(TreeNode root) {
        if (root == null) return false;
        //如果当前节点为叶子节点
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = DFS(root.left);
        if (!left) root.left = null; //删除左子树
        boolean right = DFS(root.right);
        if (!right) root.right = null;//删除右子树

        return root.val == 1 || left || right;
    }
}
