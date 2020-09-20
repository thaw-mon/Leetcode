package Year2020.September.day12;

import java.util.LinkedList;
import java.util.Queue;

public class Demo01 {

     static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        //采取中序遍历思路
        TreeNode ret = dp(pRootOfTree);
        return ret;
    }

    //问题出在如何获取头节点 : Right mid Left
    private TreeNode dp(TreeNode root) {
        if (root == null) return null;

        TreeNode right = dp(root.right); //返回的是左子树的最左节点
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        //System.out.println(root.val);
        TreeNode p = root.left; //获取左子树的最大节点
        if (p == null) return root; //左子树为null
        TreeNode left = dp(root.left);

        while (p.right != null) {
            p = p.right;
        }
        root.left = p;
        p.right = root;

        return left;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right= new TreeNode(15);
        System.out.println(new Demo01().Convert(root));
    }
}
