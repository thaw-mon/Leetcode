package Year2020.April.day02;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {

    // Definition for a binary tree node.
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个二叉树，返回它的中序 遍历。l root r
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;

        DFS(root,ret);
        return ret;
    }

    public void DFS(TreeNode root, List<Integer> inorderValue) {
        if (root.left != null) {
            DFS(root.left,inorderValue);
        }
        inorderValue.add(root.val);
        if(root.right !=null){
            DFS(root.right,inorderValue);
        }
    }
}
