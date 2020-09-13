package Year2020.March.day01;

public class Demo01 {

    /**
     * Definition for singly-linked list.
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @param preorder : 先序遍历数组 root, left ,right
     * @param inorder  ： 中序遍历数组 left , root ,right
     * @return 构造的二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int len = preorder.length;
        TreeNode root  = helper(preorder,inorder,0,len-1,0,len-1);

        return root;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = inStart; //中序的起始位置
        for (; index <= inEnd; index++) {
            if (inorder[index] == preorder[preStart])
                break;
        }
        int len = index - inStart;
        root.left = helper(preorder, inorder, preStart + 1, preStart + len, inStart, index - 1);
        root.right = helper(preorder, inorder, preStart + len + 1, preEnd, index + 1, inEnd);
        return root;
    }
}
