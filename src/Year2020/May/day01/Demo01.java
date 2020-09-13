package Year2020.May.day01;

public class Demo01 {

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
     * 翻转一棵二叉树。
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        //每轮左右子树反转
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        //交换节点
        root.left = right;
        root.right = left;

        helper(root.left);
        helper(root.right);
    }
}
