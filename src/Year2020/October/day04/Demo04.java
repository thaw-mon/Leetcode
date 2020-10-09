package Year2020.October.day04;

public class Demo04 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;

        return fitTree(pRoot.left,pRoot.right);
    }

    private boolean fitTree(TreeNode lNode, TreeNode rNode) {
        if (lNode == null || rNode == null) {
            return lNode == null && rNode == null;
        }
        boolean flag = true;
        if (lNode.val != rNode.val) {
            flag = false;
        }
        //判定子树
        flag = flag & fitTree(lNode.left, rNode.right);
        flag = flag & fitTree(lNode.right, rNode.left);

        return flag;
    }
}
