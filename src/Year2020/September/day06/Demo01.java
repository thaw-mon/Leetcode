package Year2020.September.day06;

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
     * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
     *
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        //思路 1: 把子树变为平衡二叉树并返回深度
        //2. 判定左右子树是否构成平衡二叉树，否则进行旋转(左旋，右旋操作)

        return null;
    }

    private int dp(TreeNode root) {
        if (root == null) return 0;
        int left = dp(root.left);
        int right = dp(root.right);
        //判定左右子树是否构成平衡二叉树，否则进行旋转(左旋，右旋操作)
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        }
        //旋转操作
        if(left < right){
            //TODO add 左旋操作
        }else {
            //TODO add 右旋操作

        }
        return 0; //返回最后长度
    }

    private TreeNode leftRotate(TreeNode root){

        return null;
    }
    private TreeNode rightRotate(TreeNode root){

        return null;
    }

}
