package Year2020.March.day11;

import java.util.LinkedList;
import java.util.Queue;

public class Demo01 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new Demo01().isSymmetric(root));
    }

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
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        //递归写法 : 一次从左到右遍历，一次从右到左遍历
        Queue<TreeNode> lTree = new LinkedList<>(), rTree = new LinkedList<>();
        lTree.add(root);
        rTree.add(root);
        boolean flag = true;
        while (!lTree.isEmpty()) {
            int n = lTree.size();
            for (int i = 0; i < n; i++) {
                TreeNode lNode = lTree.poll();
                TreeNode rNode = rTree.poll();
                if (lNode == null && rNode == null) {
                    continue;
                }
                if (lNode == null || rNode == null || lNode.val != rNode.val) {
                    flag = false;
                    break;
                }
                lTree.add(lNode.left);
                lTree.add(lNode.right);
                rTree.add(rNode.right);
                rTree.add(rNode.left);
            }
            if (!flag) break;
        }
        return flag;
    }
}
