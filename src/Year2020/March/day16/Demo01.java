package Year2020.March.day16;

import java.util.LinkedList;
import java.util.Queue;

public class Demo01 {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个二叉树，在树的最后一行找到最左边的值。
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        int ret = 0;
        if (root == null) return ret;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.poll();
                if (i == 0) ret = tmp.val;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
        }
        return ret;
    }
}
