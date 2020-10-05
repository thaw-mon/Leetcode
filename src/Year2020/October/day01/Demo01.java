package Year2020.October.day01;

import Year2020.September.day16.Demo04;

public class Demo01 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * <p>
     * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getTreeDepth(root) > -1;
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getTreeDepth(root.left);
        if (left == -1) return -1;
        int right = getTreeDepth(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
