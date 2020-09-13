package Year2020.April.day02;

public class Demo03 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个非空二叉树，返回其最大路径和。
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        //root默认不为null
        DFS(root);
        return maxVal;
    }

    int maxVal = Integer.MIN_VALUE;

    //至少包含一个节点
    public int DFS(TreeNode root) {
        int l = 0, r = 0;
        //4中组合 l + r + root ; l ; r ; (l,r) + root
        if (root.left != null) {
            l = DFS(root.left);
            maxVal = Math.max(maxVal, Math.max(l, l + root.val));
        }
        if (root.right != null) {
            r = DFS(root.right);
            maxVal = Math.max(maxVal, Math.max(r, r + root.val));

        }
        maxVal = Math.max(maxVal, Math.max(root.val, l + r + root.val));

        return root.val + Math.max(Math.max(l, r), 0); //返回值至少包含root
    }
}
