package Year2020.April.day02;

public class Demo01 {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。
     * （所谓一个叶子节点，就是一个没有子节点的节点）
     *
     * @param root
     * @param limit
     * @return
     */
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        //深度优先遍历
        boolean flag = DFS(root, 0, limit);
        if (flag) root = null;
        return root;
    }

    public boolean DFS(TreeNode root, int sum, int limit) {

        sum += root.val;
        //1.判定是否为叶子节点,
        if (root.left == null && root.right == null) {
            return sum < limit;
        }
        boolean flagL = true, flagR = true; //默认为true
        //判定 DFS进入下一层
        if (root.left != null) {
            flagL = DFS(root.left, sum, limit);
            if (flagL) root.left = null; //删除左节点
        }
        if (root.right != null) {
             flagR = DFS(root.right, sum, limit);
            if (flagR) root.right = null; //删除右节点
        }
        return flagL && flagR;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(-6);
        root.left = new TreeNode(-6);
        root = new Demo01().sufficientSubset(root, 0);
        System.out.println("pause");
    }
}
