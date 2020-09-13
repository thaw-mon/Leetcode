package Year2020.September.day03;

public class Demo02 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        //根据先序遍历构造二叉搜索树

        return createTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode createTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[left]);
        int subRight = left + 1;
        while (subRight < preorder.length && preorder[subRight] < root.val) {
            subRight++;
        }
        root.left = createTree(preorder, left + 1, subRight - 1);
        root.right = createTree(preorder, subRight, right);

        return root;
    }
}
